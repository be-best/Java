package bull.ProductTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bull.ProductService.ProductService;
import bull.domain.Product;

public class ProductTest {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {			
			System.out.println("������������");
			System.out.println("C��������U���޸ġ�D��ɾ����DA��ɾ�����С�I��ͨ��id��ѯ��FA����ѯ���С�Q���˳�");
			
			try {
				String line = reader.readLine();
				switch(line.toUpperCase()) {
				case "C":
					add(reader);
					break;
				case "U":
					edit(reader);
					break;
				case "D":
					delete(reader);
					break;
				case "DA":
					deleteAll(reader);
					break;
				case "I":
					findById(reader);
					break;
				case "FA":
					findAll(reader);
					break;
				case "Q":
					System.out.println("��ӭ�´�ʹ�ã�");
					System.exit(-1);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�����쳣�����������룡");
			}
		}
	}


	private static void deleteAll(BufferedReader reader) {
		// ����ɾ��
		try {
			ProductService productService = new ProductService();
			//��ѡ�е�id�浽һ��list�У�Ȼ��ProductService�����ٱ���list�е�id��
			List<Integer> list = new ArrayList<Integer>();
			while(true) {
				System.out.println("��������Ҫɾ������Ʒ���(����-1�˳�)��");
				String pidStr = reader.readLine();
				Integer pid = Integer.parseInt(pidStr);
				if(pid == -1) {
					break;
				}
				
				Product product = productService.findById(pid);

				if(product == null) {
					System.out.println("��Ʒ�����ڣ�");
				} 
				else {
					System.out.println("��ѡ��Ҫɾ����¼��" + product);
					list.add(pid);
				}
				
			}
			if(list.size() == 0) {
				System.out.println("û��ѡ��Ҫɾ���ļ�¼��");
				return;
			}
			System.out.println("�Ƿ�ɾ��ѡ�е�" + list.size() + "����¼��Y/N");
			String judge = reader.readLine();
			if(judge.equalsIgnoreCase("y")) {
				productService.deleteAll(list);
				System.out.println("�ɹ�ɾ��"+ list.size() + "����¼��");
			}
			else {
				System.out.println("����ȡ����");
			}
		} catch (Exception e) {
			System.out.println("����ɾ����¼ʧ�ܣ������²�����");
		}
		
	}


	private static void delete(BufferedReader reader) {
		// ɾ��
		try {
			System.out.println("��������Ҫɾ������Ʒ��ţ�");
			String pidStr = reader.readLine();
			Integer pid = Integer.parseInt(pidStr);
			
			ProductService productService = new ProductService();
			//��ѯ�ж��Ƿ����
			Product product = productService.findById(pid);
			if(product == null) {
				System.out.println("����Ʒ������,���������룡");
			} 
			else {
				System.out.println("����Ʒ�ǣ�" + product);
				System.out.println("�Ƿ�ɾ����Y/N");
				String judge = reader.readLine();
				if(judge.equalsIgnoreCase("y")) {					
					productService.delete(pid);
					System.out.println("ɾ���ɹ���");
				}
				else {
					System.out.println("����ȡ����");
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("ɾ��ʧ�ܣ������²�����");
		}
		
	}


	private static void findAll(BufferedReader reader) {
		// ��ѯ����
		try {
			ProductService productService = new ProductService();
			List<Map<String,Object>> list = productService.findAll();
			for (Map<String,Object> map : list) {
				System.out.println(map);
			}
			System.out.println("����"+list.size()+"����¼��");
		} catch (Exception e) {
			System.out.println("��ѯ�����쳣�����������룡");
		}
		
	}


	private static void findById(BufferedReader reader) {
		// ��ѯ
		try {
			System.out.println("��������Ҫ��ѯ����Ʒ��ţ�");
			String pidStr = reader.readLine();
			Integer pid = Integer.parseInt(pidStr);
			
			ProductService productService = new ProductService();
			//��ѯpid��Ʒ���������product.
			Product product = productService.findById(pid);
			System.out.println("��ѯ���:" + product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯʧ�ܣ����������룡");
		}
		
	}
	
	private static void edit(BufferedReader reader) {
		// �޸�
		try {
			ProductService productService = new ProductService();
			System.out.println("��������Ҫ�޸ĵ���Ʒ��ţ�");
			String pidStr = reader.readLine();
			int pid = Integer.parseInt(pidStr);
			
			//��ѯ��Ʒ
			Product product = productService.findById(pid);
			System.out.println("ԭ��Ʒ�ǣ�"+product);
			if(product == null) {
				System.out.println("����Ʒ�����ڣ�");
				return;
			}
			else {
				System.out.println("��������Ҫ�޸ĵ���Ʒ����");
				String pname = reader.readLine();
				System.out.println("��������Ҫ�޸ĵ���Ʒ�۸�");
				String priceStr = reader.readLine();
				int price = Integer.parseInt(priceStr);
				System.out.println("��������Ҫ�޸ĵ���Ʒ���ࣺ");
				String category_id = reader.readLine();
				product.setPid(pid);
				product.setPname(pname);
				product.setPrice(price);
				product.setCategory_id(category_id);
				productService.edit(product);
				System.out.println("�޸ĳɹ���");
			}
		} catch (Exception e) {
			System.out.println("�޸��쳣�����������룡");
		}
		
	}

	private static void add(BufferedReader reader) {
		//���
		try {
			ProductService productService = new ProductService();
			System.out.println("��������Ҫ��ӵ���Ʒ���ƣ�");
			String name = reader.readLine();
			System.out.println("��������Ҫ��ӵ���Ʒ�۸�");
			String priceStr = reader.readLine();
			int price = Integer.parseInt(priceStr);
			System.out.println("��������Ҫ��ӵ���Ʒ���ࣺ");
			String category_id = reader.readLine();
			Product product = new Product(null,name,price,"1",category_id);
			productService.add(product);
			System.out.println("��ӳɹ���");
		} catch (Exception e) {
			System.out.println("���ʧ�������ԣ�");
			throw new RuntimeException(e);
		} 
	}
}
