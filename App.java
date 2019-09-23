import java.io.File;
import java.lang.reflect.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

class A {}
class B extends A {}
class C extends B {
	public int x,y;
	public void Foo(){}
}
class App{
	
	public static void main(String[] args) {
		printBaseTypes("Ola");
		printBaseTypes(19);
		printBaseTypes( new C());
		printBaseTypes(FileSystems.getDefault().getRootDirectories());
		printMembers(new C());
        printMethods(new C());
        printFields(new C());
	}

	private static void printFields(Object obj) {
		System.out.print("Fields: ");
		for (Field field :obj.getClass().getFields()) {
			System.out.print(field.getName()+ " ");
		}
		System.out.println();
	}

	private static void printMethods(Object obj) {
		System.out.print("Methods: ");
		for (Method method :obj.getClass().getMethods()) {
			System.out.print(method.getName()+ " / ");
		}
		System.out.println();
	}

	private static void printMembers(Object obj) {
		System.out.print("Members: ");
		for (Constructor c :obj.getClass().getConstructors()) {
			System.out.print(c.getName()+ " / ");
		}
		System.out.println();
		printMethods(obj);
		printFields(obj);
	}

	public static void printBaseTypes(Object obj){
		Class c = obj.getClass();
		do{
			System.out.print(c+" / ");
			printInterfaces(c);
			c=c.getSuperclass();
		}while(c!=null);
	}

	private static void printInterfaces(Class c) {
		for (Class i:c.getInterfaces()){
			System.out.print(i.getName()+ " / ");
		}
		System.out.println();
	}
}
