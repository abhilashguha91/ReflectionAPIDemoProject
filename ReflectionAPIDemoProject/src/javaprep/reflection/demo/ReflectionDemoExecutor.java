package javaprep.reflection.demo;

import java.lang.reflect.Constructor;
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
		try {
			UFOEnemyShip obj1 = (UFOEnemyShip)constructor1.newInstance(3,"Some random String");
			EnemyShip enemyShip = new EnemyShip("TX-1000","AIRCRAFT_CARRIER");
			UFOEnemyShip obj2 = (UFOEnemyShip)constructor2.newInstance(enemyShip);
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
