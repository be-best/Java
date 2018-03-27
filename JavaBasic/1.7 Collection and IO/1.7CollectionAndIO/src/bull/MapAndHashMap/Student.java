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
		
		//��дhashCode()��equals()����ʵ��ȥ��
		
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
			//���Ч��
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			//��ߴ��뽡׳��
			if(this.getClass() != obj.getClass()) {
				return false;
			}
			//����ת��
			Student stu = (Student)obj;
			//�ж�����
			if(this.age != stu.age) {
				return false;
			}
			//�ж����������ж��Ƿ�Ϊ��
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
