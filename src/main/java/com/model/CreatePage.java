package com.model;

public class CreatePage {
	private int CurrentP;			//��ǰҳ��
	private int AllP;				//��ҳ��
	private int AllR;				//�ܼ�¼��
	private int PerR;				//ÿҳ��ʾ�ļ�¼��
	private String PageLink;		//��ҳ��������Ϣ
	private String PageInfo;		//��ҳ״̬��ʾ ��Ϣ
	public CreatePage(){
		CurrentP=1;
		AllP=1;
		AllR=0;
		PerR=3;
		PageLink="";
		PageInfo="";
	}
	
	public int getCurrentP() {
		return CurrentP;
	}
	
	/**���õ�ǰҳ*/
	public void setCurrentP(String currentP) {
		if(currentP==null||currentP.equals("")){
			currentP="1";
		}
		try{
			CurrentP=Integer.parseInt(currentP);		
		}catch(NumberFormatException e){					//����������������ʽ
			CurrentP=1;										//����ǰҳ����Ϊ1
			e.printStackTrace();
		}
		if(CurrentP<1){										//����ǰҳ��С��1
			CurrentP=1;										//������ҳ������Ϊ1
		}
		if(CurrentP>AllP){									//����ǰҳ�������ҳ��
			CurrentP=AllP;									//������ҳ������Ϊ��ҳ���������һҳ
		}
	}
	public int getAllP() {
		return AllP;
	}
	/**������ҳ��*/
	public void setAllP() {
		AllP = (AllR%PerR==0)?(AllR/PerR):(AllR/PerR+1);
	}
	public int getAllR() {
		return AllR;
	}
	public void setAllR(int allR) {
		AllR = allR;
	}
	public int getPerR() {
		return PerR;
	}
	public void setPerR(int perR) {
		PerR = perR;
	}
	public String getPageLink() {
		return PageLink;
	}
	/**���÷�ҳ��������Ϣ*/
	public void setPageLink(String gowhich) {
		if(gowhich==null){
			gowhich="";
		}
		if(gowhich.indexOf("?")>=0){
			gowhich+="&";
		}else{
			gowhich+="?";
		}
		if(AllP>1){							//�����ҳ������1�����ɷ�ҳ��������
			PageLink="<table border='0' cellpadding='3'><tr><td>";
			if(CurrentP>1){					//����ǰҳ�����1������ʾ����ҳ���͡���һҳ��������
				PageLink+="<a href="+gowhich+"showpage=1>��ҳ</a>&nbsp;";
				PageLink+="<a href="+gowhich+"showpage="+(CurrentP-1)+">��һҳ</a>&nbsp;";				
			}
			if(CurrentP<AllP){				//����ǰҳ��С����ҳ��������ʾ����һҳ���͡�βҳ��������
				PageLink+="<a href="+gowhich+"showpage="+(CurrentP+1)+">��һҳ</a>&nbsp;";
				PageLink+="<a href="+gowhich+"showpage="+AllP+">βҳ</a>&nbsp;";	
			}
			PageLink+="</td></tr></table>";
		}
	}
	public String getPageInfo() {
		return PageInfo;
	}
	/**���÷�ҳ״̬��ʾ��Ϣ*/
	public void setPageInfo() {
		if(AllP>1){
			PageInfo="<table border='0' cellpadding='3'><tr><td>";
			PageInfo+="ÿҳ��ʾ��"+PerR+"/"+AllR+"����¼";
			PageInfo+="</td></tr></table>";
		}
	}
	

}
