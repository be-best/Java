package bull.MapAndHashMap;

public class Student {
		String name;
		int age;
		
		public Student() {
			
		}
		
		public Student(String name,int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
		
		//重写hashCode()和equals()方法实现去重
		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			//+age
			result = prime*result+age;
			//+name.hashCode()
			result = prime*result+((name == null)?0 : name.hashCode());
			return result;
		}
		
		public boolean equals(Object obj) {
			//提高效率
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			//提高代码健壮性
			if(this.getClass() != obj.getClass()) {
				return false;
			}
			//向下转型
			Student stu = (Student)obj;
			//判断年龄
			if(this.age != stu.age) {
				return false;
			}
			//判断姓名，先判断是否为空
			if(this.name == null) {
				if(stu.name != null) {
					return false;
				}
				else if(!this.name.equals(stu.name)) {
					return false;
				}
			}
			return true;
		}
	
}
