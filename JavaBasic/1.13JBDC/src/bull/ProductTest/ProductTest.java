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
			System.out.println("请输入操作命令：");
			System.out.println("C：创建、U：修改、D：删除、DA：删除所有、I：通过id查询、FA：查询所有、Q：退出");
			
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
					System.out.println("欢迎下次使用！");
					System.exit(-1);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("操作异常，请重新输入！");
			}
		}
	}


	private static void deleteAll(BufferedReader reader) {
		// 批量删除
		try {
			ProductService productService = new ProductService();
			//把选中的id存到一个list中，然后ProductService里面再遍历list中的id。
			List<Integer> list = new ArrayList<Integer>();
			while(true) {
				System.out.println("请输入你要删除的商品编号(输入-1退出)：");
				String pidStr = reader.readLine();
				Integer pid = Integer.parseInt(pidStr);
				if(pid == -1) {
					break;
				}
				
				Product product = productService.findById(pid);

				if(product == null) {
					System.out.println("商品不存在！");
				} 
				else {
					System.out.println("已选中要删除记录：" + product);
					list.add(pid);
				}
				
			}
			if(list.size() == 0) {
				System.out.println("没有选择要删除的记录！");
				return;
			}
			System.out.println("是否删除选中的" + list.size() + "条记录？Y/N");
			String judge = reader.readLine();
			if(judge.equalsIgnoreCase("y")) {
				productService.deleteAll(list);
				System.out.println("成功删除"+ list.size() + "条记录！");
			}
			else {
				System.out.println("操作取消！");
			}
		} catch (Exception e) {
			System.out.println("批量删除记录失败，请重新操作！");
		}
		
	}


	private static void delete(BufferedReader reader) {
		// 删除
		try {
			System.out.println("请输入你要删除的商品编号：");
			String pidStr = reader.readLine();
			Integer pid = Integer.parseInt(pidStr);
			
			ProductService productService = new ProductService();
			//查询判断是否存在
			Product product = productService.findById(pid);
			if(product == null) {
				System.out.println("此商品不存在,请重新输入！");
			} 
			else {
				System.out.println("此商品是：" + product);
				System.out.println("是否删除？Y/N");
				String judge = reader.readLine();
				if(judge.equalsIgnoreCase("y")) {					
					productService.delete(pid);
					System.out.println("删除成功！");
				}
				else {
					System.out.println("操作取消！");
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("删除失败，请重新操作！");
		}
		
	}


	private static void findAll(BufferedReader reader) {
		// 查询所有
		try {
			ProductService productService = new ProductService();
			List<Map<String,Object>> list = productService.findAll();
			for (Map<String,Object> map : list) {
				System.out.println(map);
			}
			System.out.println("共有"+list.size()+"条记录！");
		} catch (Exception e) {
			System.out.println("查询所有异常，请重新输入！");
		}
		
	}


	private static void findById(BufferedReader reader) {
		// 查询
		try {
			System.out.println("请输入你要查询的商品编号：");
			String pidStr = reader.readLine();
			Integer pid = Integer.parseInt(pidStr);
			
			ProductService productService = new ProductService();
			//查询pid商品并输出整个product.
			Product product = productService.findById(pid);
			System.out.println("查询结果:" + product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败，请重新输入！");
		}
		
	}
	
	private static void edit(BufferedReader reader) {
		// 修改
		try {
			ProductService productService = new ProductService();
			System.out.println("请输入你要修改的商品编号：");
			String pidStr = reader.readLine();
			int pid = Integer.parseInt(pidStr);
			
			//查询商品
			Product product = productService.findById(pid);
			System.out.println("原商品是："+product);
			if(product == null) {
				System.out.println("此商品不存在！");
				return;
			}
			else {
				System.out.println("请输入你要修改的商品名称");
				String pname = reader.readLine();
				System.out.println("请输入你要修改的商品价格：");
				String priceStr = reader.readLine();
				int price = Integer.parseInt(priceStr);
				System.out.println("请输入你要修改的商品分类：");
				String category_id = reader.readLine();
				product.setPid(pid);
				product.setPname(pname);
				product.setPrice(price);
				product.setCategory_id(category_id);
				productService.edit(product);
				System.out.println("修改成功！");
			}
		} catch (Exception e) {
			System.out.println("修改异常，请重新输入！");
		}
		
	}

	private static void add(BufferedReader reader) {
		//添加
		try {
			ProductService productService = new ProductService();
			System.out.println("请输入你要添加的商品名称：");
			String name = reader.readLine();
			System.out.println("请输入你要添加的商品价格：");
			String priceStr = reader.readLine();
			int price = Integer.parseInt(priceStr);
			System.out.println("请输入你要添加的商品分类：");
			String category_id = reader.readLine();
			Product product = new Product(null,name,price,"1",category_id);
			productService.add(product);
			System.out.println("添加成功！");
		} catch (Exception e) {
			System.out.println("添加失败请重试！");
			throw new RuntimeException(e);
		} 
	}
}
