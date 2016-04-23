/*
 * 名称：幸运抽奖系统
 * 作者：chen
 * 版本：1.3
 * 日期：2016年4月22日
 *
 */
package game;

import java.util.Random;
import java.util.Scanner;

public class Lucky {
	
	static String[] names=new String[10];
	static String[] passWords=new String[10];
	static int[] cardNos=new int[10];
	
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		Random random=new Random();//用于产生随机数
		
		int index=-1;
		boolean flag=false;//是否登录
		String key=null;//主界面循环控制
		do{
			
			System.out.println("*****");
			System.out.println("欢迎进入幸运抽奖系统");
			System.out.println("*****");
			System.out.println("\t1.注册");
			System.out.println("\t2.登录");
			System.out.println("\t3.抽奖");
			System.out.println("\t0.退出");
			System.out.println("*****************************");
			
			System.out.println("请输入您的选择：");
			int choice=input.nextInt();
			switch (choice) {
			
			case 1:		//	注册
				System.out.println(">>>注册");
				for (int i = 0; i <names.length; i++) {
					if(names[i]==null){						
						index=i;
						break;
					}
					if(i==10){
						System.out.println("对不起,存储空间不够,无法注册!");
					}
				}
	
				//对应相同下标存储同一个账号及其密码与会员号
				System.out.println("请填写：");
				System.out.println("账号：");
				names[index]=input.next();
				System.out.println("密码：");
				passWords[index]=input.next();
				cardNos[index]=1+random.nextInt(9);  //产生一个1~9的
				
				System.out.println("\t注册成功!");
				System.out.println("您的账号为："+names[index]);
				System.out.println("您的密码为："+"******");
				System.out.println("您的会员号为："+cardNos[index]);
				++index;
				
				break;
				
			case 2:		//登录
				System.out.println(">>>登录");
				int sum=0;//记录密码错误次数
				
				System.out.println("账号：");
				String nameTem=input.next();

				System.out.println("密码：");
				String passWordTemp=input.next();
				
				//登陆账户密码检测
				for(int i=0;i<10;i++){
					if(passWordTemp.equals(passWords[i]) && nameTem.equals(names[i])){
					System.out.println("登陆成功！");
					flag=true;//已登录
					break;
				}else{
						for(sum=1;sum<3;sum++){
							if(!passWordTemp.equals(passWords[i])||!nameTem.equals(names[i])){						
								System.out.println("账号或密码错误！请重新输入...");
								System.out.println("账号：");
								nameTem=input.next();
								System.out.println("密码：");
								passWordTemp=input.next();
								
								if(sum==2){
									System.out.println("密码错误3次！请稍后重试...");
								}
							}
						}
					}
				}
				
				break;
				
			case 3:		//抽奖
				System.out.println(">>>抽奖");
				if(flag){
					//生成随机数组
					int[] luckyNumber=new int[5];
					for(int i=0;i<5;i++){	
						luckyNumber[i]=1+random.nextInt(9);//产生幸运数字1~9
						//幸运号码去重
						for(int j=0;j<i;j++){
							if(luckyNumber[i]==luckyNumber[j]){
								--i;
								break;
							}
						}
					}
					//显示幸运数字
					for (int i = 0; i < luckyNumber.length; i++) {
						System.out.println("幸运数字为：");
						System.out.print(luckyNumber[i]+"  ");
						if (i==luckyNumber.length-1) {
							System.out.println();
						}
					}
					boolean win=false;
					for(int i=0;i<5;i++){
						for(int j=0;j<10;j++){
							if(luckyNumber[i]==cardNos[j]){
								System.out.println("恭喜您，您是幸运用户！");
								win=true;
								break;
							}							
				 		}
					}
					if(win==false){
								System.out.println("很遗憾！您不是幸运用户！");
							}
				}else{
						System.out.println("请您先登录！");
				}			
				
				break;
				
			case 0:		//退出				
				System.out.println("退出系统...谢谢使用！");
				flag=false;
				return;
				
			default:
				System.out.println("您的输入不合法！请输入0~3!");
				break;
			}
			System.out.println("是否继续?(y/n)");
			key=input.next();
		}while(key.equalsIgnoreCase("y"));
		System.out.println("退出系统...谢谢使用！");
	}
}

