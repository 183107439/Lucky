/*
 * ���ƣ����˳齱ϵͳ
 * ���ߣ�chen
 * �汾��1.3
 * ���ڣ�2016��4��22��
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
		Random random=new Random();//���ڲ��������
		
		int index=-1;
		boolean flag=false;//�Ƿ��¼
		String key=null;//������ѭ������
		do{
			
			System.out.println("*****");
			System.out.println("��ӭ�������˳齱ϵͳ");
			System.out.println("*****");
			System.out.println("\t1.ע��");
			System.out.println("\t2.��¼");
			System.out.println("\t3.�齱");
			System.out.println("\t0.�˳�");
			System.out.println("*****************************");
			
			System.out.println("����������ѡ��");
			int choice=input.nextInt();
			switch (choice) {
			
			case 1:		//	ע��
				System.out.println(">>>ע��");
				for (int i = 0; i <names.length; i++) {
					if(names[i]==null){						
						index=i;
						break;
					}
					if(i==10){
						System.out.println("�Բ���,�洢�ռ䲻��,�޷�ע��!");
					}
				}
	
				//��Ӧ��ͬ�±�洢ͬһ���˺ż����������Ա��
				System.out.println("����д��");
				System.out.println("�˺ţ�");
				names[index]=input.next();
				System.out.println("���룺");
				passWords[index]=input.next();
				cardNos[index]=1+random.nextInt(9);  //����һ��1~9��
				
				System.out.println("\tע��ɹ�!");
				System.out.println("�����˺�Ϊ��"+names[index]);
				System.out.println("��������Ϊ��"+"******");
				System.out.println("���Ļ�Ա��Ϊ��"+cardNos[index]);
				++index;
				
				break;
				
			case 2:		//��¼
				System.out.println(">>>��¼");
				int sum=0;//��¼����������
				
				System.out.println("�˺ţ�");
				String nameTem=input.next();

				System.out.println("���룺");
				String passWordTemp=input.next();
				
				//��½�˻�������
				for(int i=0;i<10;i++){
					if(passWordTemp.equals(passWords[i]) && nameTem.equals(names[i])){
					System.out.println("��½�ɹ���");
					flag=true;//�ѵ�¼
					break;
				}else{
						for(sum=1;sum<3;sum++){
							if(!passWordTemp.equals(passWords[i])||!nameTem.equals(names[i])){						
								System.out.println("�˺Ż������������������...");
								System.out.println("�˺ţ�");
								nameTem=input.next();
								System.out.println("���룺");
								passWordTemp=input.next();
								
								if(sum==2){
									System.out.println("�������3�Σ����Ժ�����...");
								}
							}
						}
					}
				}
				
				break;
				
			case 3:		//�齱
				System.out.println(">>>�齱");
				if(flag){
					//�����������
					int[] luckyNumber=new int[5];
					for(int i=0;i<5;i++){	
						luckyNumber[i]=1+random.nextInt(9);//������������1~9
						//���˺���ȥ��
						for(int j=0;j<i;j++){
							if(luckyNumber[i]==luckyNumber[j]){
								--i;
								break;
							}
						}
					}
					//��ʾ��������
					for (int i = 0; i < luckyNumber.length; i++) {
						System.out.println("��������Ϊ��");
						System.out.print(luckyNumber[i]+"  ");
						if (i==luckyNumber.length-1) {
							System.out.println();
						}
					}
					boolean win=false;
					for(int i=0;i<5;i++){
						for(int j=0;j<10;j++){
							if(luckyNumber[i]==cardNos[j]){
								System.out.println("��ϲ�������������û���");
								win=true;
								break;
							}							
				 		}
					}
					if(win==false){
								System.out.println("���ź��������������û���");
							}
				}else{
						System.out.println("�����ȵ�¼��");
				}			
				
				break;
				
			case 0:		//�˳�				
				System.out.println("�˳�ϵͳ...ллʹ�ã�");
				flag=false;
				return;
				
			default:
				System.out.println("�������벻�Ϸ���������0~3!");
				break;
			}
			System.out.println("�Ƿ����?(y/n)");
			key=input.next();
		}while(key.equalsIgnoreCase("y"));
		System.out.println("�˳�ϵͳ...ллʹ�ã�");
	}
}

