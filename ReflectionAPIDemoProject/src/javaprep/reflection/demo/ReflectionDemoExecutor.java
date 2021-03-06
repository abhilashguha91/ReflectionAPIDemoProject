package javaprep.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemoExecutor extends EnemyShip {

	public static void main(String[] args){
		
		Class reflectUFOEnemyShip = UFOEnemyShip.class;
		
		// Retrieving the class name
		String className = reflectUFOEnemyShip.getName();
		System.out.println(className);
		
		// Retrieving the class modifiers
		int classModifier = reflectUFOEnemyShip.getModifiers();
		System.out.println("isPublic: "+Modifier.isPublic(classModifier));
		System.out.println("isPrivate: "+Modifier.isPrivate(classModifier));
		System.out.println("isInterface: "+Modifier.isInterface(classModifier));
		System.out.println("isAbstract: "+Modifier.isAbstract(classModifier));
		System.out.println("isFinal: "+Modifier.isFinal(classModifier));
		System.out.println("isStatic: "+Modifier.isStatic(classModifier));
		System.out.println("isStrict: "+Modifier.isStrict(classModifier));
		System.out.println("isSynchronized: "+Modifier.isSynchronized(classModifier));

		
		// Retrieving the class Interfaces
		Class[] interfaceList = reflectUFOEnemyShip.getInterfaces();
		for(Class eachInterface : interfaceList) {
			System.out.println("Interface Implemented: "+eachInterface.getName());
		}
		
		// Retrieving the Super class
		Class superClass = reflectUFOEnemyShip.getSuperclass();
		System.out.println("Super Class: "+superClass.getName()); // If there were no super classes it would show java.lang.Object
		
		// Retrieve all methods of the Class
		Method[] methods = reflectUFOEnemyShip.getMethods(); // This will only return the public methods of the class(Even the inherited ones).
		for(Method eachMethod : methods) {
			System.out.print("Method: "+eachMethod.getReturnType()+" "+eachMethod.getName()+ " ");
			for(Class parameter : eachMethod.getParameterTypes())
			System.out.print(parameter.getName());
			System.out.println();
		}
		
		// Retrieve the constructors of the Class
		Constructor[] constructors = reflectUFOEnemyShip.getConstructors();
		for(Constructor eachConstructor : constructors) {
			System.out.print("Constructor Parameters: ");
			for(Class eachParameter : eachConstructor.getParameterTypes()) {
				System.out.print(eachParameter.getName()+" ");
			}
			System.out.println();
		}
		
		// Retrieving their parameters
		for(Constructor eachConstructor : constructors) {
			System.out.print("Constructor Parameters: ");
			for(Class eachParameter : eachConstructor.getParameterTypes()) {
				System.out.print(eachParameter.getName()+" ");
			}
			System.out.println();
		}
		
		// Retrieve the constructors of the Class one by one, by sending different parameters
		Constructor constructor1 = null;
		Constructor constructor2 = null;
		
		try {
			constructor1 = reflectUFOEnemyShip.getConstructor(int.class, String.class);
			constructor2 = reflectUFOEnemyShip.getConstructor(new Class[] {EnemyShip.class});
			//or,
			constructor2 = reflectUFOEnemyShip.getConstructor(EnemyShip.class);
			//or,
			EnemyShip enemyShip = new EnemyShip();
			constructor2 = reflectUFOEnemyShip.getConstructor(enemyShip.getClass());
			// Mind you this int.class, String.class or EnemyShip.class the basic idea is to 
			// tell the type of arguments (not reference or values) to just identify the constructor and 
			// return it.
			
			// These give no such method exception, as the validity of the call is handled in the runtime.
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		// Instantiate objects with the help of these constructors
		UFOEnemyShip obj1 = null;
		UFOEnemyShip obj2 = null;
		try {
			obj1 = (UFOEnemyShip)constructor1.newInstance(3,"Some random String");
			EnemyShip enemyShip = new EnemyShip("TX-1000","AIRCRAFT_CARRIER");
			obj2 = (UFOEnemyShip)constructor2.newInstance(enemyShip);
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Retrieving fields(with any accessor) from a class by name
		Field privateFieldIdCode = null;
		try {
			privateFieldIdCode = UFOEnemyShip.class.getDeclaredField("idCode");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Retrieving the Value of this private field
		String privateFieldIdCodeValue = null;
		
		try {
			// Change accessibility, as private field will be inaccessible
			privateFieldIdCode.setAccessible(true);
			// Get the value by Field.get(obj) quite opposite of how we normally get value of a field from
			// an object
			privateFieldIdCodeValue = (String)privateFieldIdCode.get(obj1);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Private Field ID Code for Object:"+obj1+" :: is : "+privateFieldIdCodeValue);
		
		// Retrieving a method(with any accesor) from a class by name
		Method privateMethodFetPrivateMethod = null;
		try {
			privateMethodFetPrivateMethod = UFOEnemyShip.class.getDeclaredMethod("getPrivateMethod", null);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Invoking the private method
		// Change accessibility, as private method will be inaccessible
		privateMethodFetPrivateMethod.setAccessible(true);
		String methodReturnString = null;
		try {
			// we invoke the method with object and arguments, however here it is null
			methodReturnString = (String) privateMethodFetPrivateMethod.invoke(obj1, null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Private Method for Object:"+obj1+" :: returned : "+methodReturnString);
		
		// Same thing now with parameters
		// This class array tells what kind of params the method accepts
		Class[] params = new Class[] {int.class, String.class};
		// This object array tells you the objects we are going to pass as parameters when we invoke the method
		Object[] paramObjs = new Object[] {1,new String("I'm tired of random strings")};
		Method privateMethodParameterizedPrivateMethod = null;
		
		try {
			privateMethodParameterizedPrivateMethod = UFOEnemyShip.class.getDeclaredMethod("getParameterizedPrivateMethod", params);
			
			// break accessibility
			privateMethodParameterizedPrivateMethod.setAccessible(true);
			//invoke with parameters
			System.out.println(privateMethodParameterizedPrivateMethod.invoke(obj1, paramObjs));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
