package db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;


/*Esta solucion esta basada en el SessionFactory de Hibernate, en vez del EntityManager de JPA*/

public class SessionFactoryRule implements MethodRule
{
    private SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;

    @Override
    public Statement apply(final Statement statement, FrameworkMethod method, Object test) 
    {
    	return new Statement() 
    	{
    		@Override
    		public void evaluate() throws Throwable 
    		{
    			createSessionFactory();
    			createSession();
    			beginTransaction();
    			
    			try
    			{
    				statement.evaluate();
    			} 
    			finally 
    			{
    				shutdown();
    			}
    		}
    	};
    }
    

    private void shutdown() 
    {
    	try 
    	{
    		try 
    		{    			
    			try 
    			{
    				transaction.rollback();
    			} 
    			catch (Exception ex) 
    			{
    				ex.printStackTrace();
    			}
    			
    			session.close();
    		} 
    		catch (Exception ex) 
    		{
    			ex.printStackTrace();
    		}
    		
    		sessionFactory.close();
    	} 
    	catch (Exception ex) 
    	{
    		ex.printStackTrace();
    	}
    }

    
    private void createSessionFactory(Class<?>... clases) //Class<?> especifica que es cualquier tipo de clase
    {																//Esos puntos suspensivos despeus del tipo de dato indican que le paso un nro variable de argumentos al metodo
    	Configuration configuration = new Configuration();
    	
    	for(Class<?> clase : clases)
    	{
    		configuration.addAnnotatedClass(clase);		//Esto agrega las clases a persistir a la configuracion de hibernate
    	}
    	
    	//Lo siguiente agrega las propiedades que deberian estar en el persistence.xml
    	
        configuration.setProperty("hibernate.archive.autodetection", "class, hbm");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
    	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
    	configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
    	configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testdb");
    	configuration.setProperty("hibernate.hbm2ddl.auto", "create");
    	
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

    
    public void createSession() 
    {
    	session = sessionFactory.openSession();
    }

    
    public void commit() 
    {
    	transaction.commit();
    }

    
    public void beginTransaction() 
    {
    	transaction = session.beginTransaction();
    }

    
    public Session getSession()
    {
    	return session;
    }

}