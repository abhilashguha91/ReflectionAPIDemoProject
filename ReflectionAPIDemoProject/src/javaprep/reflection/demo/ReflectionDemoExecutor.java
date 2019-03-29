package javaprep.reflection.demo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemoExecutor extends EnemyShip {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
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
	}

}
