package ezc.sapconnection;

import com.sap.mw.jco.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public final class EzSAPHandler 
{

	private static IRepository repository 		= null;
	private static Hashtable repositoryHash=new Hashtable();
	private static String SID 					= "R3";
    public  static final String COMMIT 			= "BAPI_TRANSACTION_COMMIT";
    public  static final String ROLLBACK 		= "BAPI_TRANSACTION_ROLLBACK";
    public  static String R3_NO_OF_CONN,R3_CLIENT,R3_USER_ID,R3_PASSWD,R3_HOST,R3_SYS_NO;
    
    
    @Autowired
    public EzSAPHandler(@Value("${jco2.r3_no_of_conn}") String R3_NO_OF_CONN,@Value("${jco2.r3_client}") String R3_CLIENT,@Value("${jco2.r3_user_id}") String R3_USER_ID,@Value("${jco2.r3_passwd}") String R3_PASSWD,@Value("${jco2.r3_host}") String R3_HOST,@Value("${jco2.r3_sys_no}") String R3_SYS_NO) {
    	EzSAPHandler.R3_NO_OF_CONN = R3_NO_OF_CONN;
    	EzSAPHandler.R3_CLIENT = R3_CLIENT;
    	EzSAPHandler.R3_USER_ID = R3_USER_ID;
    	EzSAPHandler.R3_PASSWD = R3_PASSWD;
    	EzSAPHandler.R3_HOST = R3_HOST;
    	EzSAPHandler.R3_SYS_NO = R3_SYS_NO;
    }
    
	/*
	 * private static void createConnectionPool() { try{
	 * System.out.println(">>>>>>>>>> Enter into createConnectionPool ...");
	 * JCO.PoolManager poolManager = JCO.getClientPoolManager(); JCO.Pool pool =
	 * poolManager.getPool(SID); System.out.println(">>>>>>>>>> poolManager "+
	 * poolManager + "JCO.Pool ..."+pool); if(pool == null){ //EzERPConnParams
	 * obj=new EzERPConnParams(); //Hashtable params = obj.ezGetERPConnParams();
	 * JCO.addClientPool(SID,10,"500","chanumanthu","initpass11","EN",
	 * "10.192.222.20","01");
	 * //System.out.println(SID+">>>"+params.get("R3_NO_OF_CONN")+">>>"+params.get(
	 * "R3_CLIENT")+">>>"+params.get("R3_USER_ID")+">>>"+params.get("R3_PASSWD")+
	 * ">>>"+"EN"+">>>"+params.get("R3_HOST")+">>>"+params.get("R3_SYS_NO"));
	 * System.out.println("Connection Pool Created Successfully..."); } } catch
	 * (JCO.Exception Ex) {
	 * System.out.println(">>>>>>>>>Problem Occured while Creating Connection Pool:"
	 * + Ex.getMessage()); } }
	 * 
	 * private static boolean closeConnectionPool(){ try{
	 * 
	 * 
	 * System.out.println(">>>>>>Before Calling removePool()");
	 * JCO.getClientPoolManager().removePool(SID);
	 * System.out.println(">>>>>>After Calling removePool()"); repository=null;
	 * return true; }catch(Exception Ex){
	 * System.out.println(">>>>>>Problem while removing JCO Connectons:" +
	 * Ex.getMessage()); return false; }
	 * 
	 * }
	 */  	
	/*
	 * private static IRepository getRepository() { if (repository == null) { try{
	 * repository= JCO.createRepository("MYRepository",getSAPConnection()); }
	 * catch(JCO.Exception Ex) {
	 * System.out.println(">>>>>>>>>>Problem Occured while creating Repository:"+
	 * Ex.getMessage()); } } return repository; }
	 */
	/*
	 * private static JCO.Function exec(JCO.Client client,String st) { try{
	 * JCO.Function fn = getFunction(st); client.execute(fn); return fn;
	 * }catch(Exception ex){
	 * System.out.println("Problem in Commit  : "+ex.getMessage()); return null; } }
	 */
	/*
	 * public static JCO.Function getFunction(String funName) { try{ return new
	 * JCO.Function((EzSAPHandler.getRepository()).getFunctionTemplate(funName)); }
	 * catch(Exception Ex) {
	 * System.out.println(">>>>>>>Problem occured while getting Function:"+Ex.
	 * getMessage()); return null; } }
	 */
	/*
	 * public static JCO.Client getSAPConnection(){ JCO.Client client =
	 * JCO.getClient(SID); if (client==null){ createConnectionPool(); try{ client=
	 * JCO.getClient(SID); } catch (JCO.Exception Ex) {
	 * System.out.println(">>>>>>Problem while getting Connecton:" +
	 * Ex.getMessage()); } } return client; }
	 */
	
	/*
	 * public static boolean removeSAPConnectionPool(){
	 * 
	 * System.out.println(">>>>>>removeSAPConnection()");
	 * System.out.println(">>>>>>Before calling closeConnectionPool()"); return
	 * closeConnectionPool();
	 * 
	 * 
	 * }
	 * 
	 * public static JCO.Function commit(JCO.Client client) throws Exception {
	 * return exec(client,COMMIT); } public static JCO.Function rollback(JCO.Client
	 * client) throws Exception { return exec(client,ROLLBACK); }
	 */
	
	private static void createConnectionPool(String  sid)
  	{
		  
		try{
				System.out.println(">>>>>>>>>> Enter into createConnectionPool ..."+sid);
       			JCO.PoolManager poolManager = JCO.getClientPoolManager();
       			JCO.Pool pool = poolManager.getPool(sid);
       			System.out.println(">>>>>>>>>> poolManager "+ poolManager + "JCO.Pool ..."+pool);
        		if(pool == null){
        			System.out.println(":::::R3_NO_OF_CONN:::"+R3_NO_OF_CONN);
        			System.out.println(":::::R3_CLIENT:::"+R3_CLIENT);
        			System.out.println(":::::R3_USER_ID:::"+R3_USER_ID);
        			System.out.println(":::::R3_PASSWD:::"+R3_PASSWD);
        			System.out.println(":::::R3_HOST:::"+R3_HOST);
        			System.out.println(":::::R3_SYS_NO:::"+R3_SYS_NO);
        			JCO.addClientPool(sid,Integer.parseInt(R3_NO_OF_CONN),R3_CLIENT,R3_USER_ID,R3_PASSWD,"EN",R3_HOST,R3_SYS_NO);
                    System.out.println("Connection Pool Created Successfully..."+sid);
        		}
		}
		catch (JCO.Exception Ex)
		{
			System.out.println(">>>>>>>>>Problem Occured while Creating Connection Pool:" + Ex.getMessage());
  		}
 	}

  	private static boolean closeConnectionPool(String sid){
  		try{


	  			System.out.println(">>>>>>Before Calling removePool()"+sid);
		  		JCO.getClientPoolManager().removePool(sid);
	  			System.out.println(">>>>>>After Calling removePool()"+sid);
	  			IRepository repository = (IRepository)repositoryHash.get(sid);
	  		    repository=null;
	  		    return true;
  		}catch(Exception Ex){
  			System.out.println(">>>>>>Problem while removing JCO Connectons:" + Ex.getMessage());
  			return false;
  		}

  	}

    private static IRepository getRepository(String sid)
    {
    	IRepository repository = (IRepository)repositoryHash.get(sid);
    	if (repository == null) {
    		try{
    			    System.out.println(">>>>>>Before Creating repository for:"+sid);
    				repository= JCO.createRepository(sid,getSAPConnection(sid));
    				repositoryHash.put(sid,repository);
    				System.out.println(">>>>>>After Creating repository for:"+sid);
       		}
       		catch(JCO.Exception Ex)
       		{
       			System.out.println(">>>>>>>>>>Problem Occured while creating Repository:"+ Ex.getMessage());
       		}
       	}
  		return repository;
  	}

    private static JCO.Function exec(JCO.Client client,String st,String sid)
    {
		try{
			 JCO.Function fn = getFunction(st,sid);
             client.execute(fn);
             return fn;
		}catch(Exception ex){
		       System.out.println("Problem in Commit  : "+ex.getMessage());
               return null;
		}
	}

	public static JCO.Function getFunction(String funName,String sid)
	{
		try{
			return new JCO.Function((EzSAPHandler.getRepository(sid)).getFunctionTemplate(funName));
		}
		catch(Exception Ex)
		{
			System.out.println(">>>>>>>Problem occured while getting Function:"+Ex.getMessage());
			return null;
		}
	}

	public static JCO.Client getSAPConnection(String sid){
  		JCO.Client client = JCO.getClient(sid);
 		if (client==null){
       		   createConnectionPool(sid);
               try{
      				client= JCO.getClient(sid);
        		}
        		catch (JCO.Exception Ex)
        		{
        			System.out.println(">>>>>>Problem while getting Connecton:" + Ex.getMessage());
		        }
		}
		return client;
  	}

	public static boolean  removeSAPConnectionPool(String sid){

			 System.out.println(">>>>>>removeSAPConnection()");
			 System.out.println(">>>>>>Before calling closeConnectionPool()");
			 return closeConnectionPool(sid);


	}

	public static JCO.Function commit(JCO.Client client,String sid) throws Exception
	{
		return exec(client,COMMIT,sid);
	}
	public static JCO.Function rollback(JCO.Client client,String sid) throws Exception
	{
		return exec(client,ROLLBACK,sid);
	}

	public static boolean isJCOEnabled(String methodName){
		methodName = methodName.toUpperCase();
		ResourceBundle resBundle = null;
		try{
			resBundle=ResourceBundle.getBundle("JCOMethodNames");
			if (resBundle.getString(methodName)!=null){
				String opt = resBundle.getString(methodName);
				System.out.println("Method Found..................."+methodName+">>>>>>>>>>>>>"+opt);
				if ("Y".equalsIgnoreCase(opt.trim())){
					return true;
				}
			}
		}
		catch(Exception ex){
			System.out.println("Problem with Resource Bundle"+ex.getMessage());
		}
		return false;
	}
	public static void printNames(){
		ResourceBundle resBundle = null;
		try{
			resBundle=ResourceBundle.getBundle("JCOMethodNames");
			Enumeration enumaration = resBundle.getKeys();

			while (enumaration.hasMoreElements()){
				String key = (String) enumaration.nextElement();
				System.out.println(key+">>>>>>>>"+resBundle.getString(key));
			}
		}
		catch(Exception ex){
			System.out.println("Problem with Resource Bundle"+ex.getMessage());
		}
	}
	
}
