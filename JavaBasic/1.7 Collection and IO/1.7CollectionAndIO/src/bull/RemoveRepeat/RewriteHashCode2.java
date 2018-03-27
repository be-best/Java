package bull.RemoveRepeat;

import java.util.HashSet;

/*
 * 重写equals和hashCode方法
 */
public class RewriteHashCode2 {
	public static void main(String[] args) {
		//创建集合对象
		HashSet<Person> hs = new HashSet<Person>();
		//创建Person对象
		Person p1 = new Person("张三",10);
		Person p2 = new Person("李四",11);
		Person p3 = new Person("李四",11);
		//添加集合元素
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		//遍历集合
		for (Person person : hs) {
			System.out.println(person);
		}
	}
}

class Person {
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	//重写toString方法
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	//重写hashCode方法
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result= result+age
		result = prime*1 + result;
		//result=result+name.hashCode()
		//name=null返回0，否则返回name.hashCode().
		result = prime*result + ((name == null)?0 : name.hashCode());
		return result;
	}
	//重写equals方法
	public boolean equals(Object obj) {
		//提高效率
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		//提高代码健壮性,不是同一个类型就直接返回false,省得向下转型了
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		//向下转型
		Person p = (Person)obj;
		if(this.age != p.age) {
			return false;
		}
		if(this.name == null) {
			if(p.name != null) {
				return false;
			}
			
		}
		else if(!this.name.equals(p.name)) {
			return false;
		}
		return true;
	}
	
}