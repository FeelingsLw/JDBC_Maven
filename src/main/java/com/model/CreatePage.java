package com.model;

public class CreatePage {
	private int CurrentP;			//当前页码
	private int AllP;				//总页数
	private int AllR;				//总记录数
	private int PerR;				//每页显示的记录数
	private String PageLink;		//分页导航栏信息
	private String PageInfo;		//分页状态显示 信息
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
	
	/**设置当前页*/
	public void setCurrentP(String currentP) {
		if(currentP==null||currentP.equals("")){
			currentP="1";
		}
		try{
			CurrentP=Integer.parseInt(currentP);		
		}catch(NumberFormatException e){					//若参数不是数字形式
			CurrentP=1;										//将当前页设置为1
			e.printStackTrace();
		}
		if(CurrentP<1){										//若当前页码小于1
			CurrentP=1;										//将当关页码设置为1
		}
		if(CurrentP>AllP){									//若当前页码大于总页数
			CurrentP=AllP;									//将当关页码设置为总页数，即最后一页
		}
	}
	public int getAllP() {
		return AllP;
	}
	/**计算总页数*/
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
	/**设置分页导航栏信息*/
	public void setPageLink(String gowhich) {
		if(gowhich==null){
			gowhich="";
		}
		if(gowhich.indexOf("?")>=0){
			gowhich+="&";
		}else{
			gowhich+="?";
		}
		if(AllP>1){							//如果总页数大于1，生成分页导航链接
			PageLink="<table border='0' cellpadding='3'><tr><td>";
			if(CurrentP>1){					//若当前页码大于1，则显示“首页”和”上一页“超链接
				PageLink+="<a href="+gowhich+"showpage=1>首页</a>&nbsp;";
				PageLink+="<a href="+gowhich+"showpage="+(CurrentP-1)+">上一页</a>&nbsp;";				
			}
			if(CurrentP<AllP){				//若当前页码小于总页数，则显示“下一页”和”尾页“超链接
				PageLink+="<a href="+gowhich+"showpage="+(CurrentP+1)+">下一页</a>&nbsp;";
				PageLink+="<a href="+gowhich+"showpage="+AllP+">尾页</a>&nbsp;";	
			}
			PageLink+="</td></tr></table>";
		}
	}
	public String getPageInfo() {
		return PageInfo;
	}
	/**设置分页状态显示信息*/
	public void setPageInfo() {
		if(AllP>1){
			PageInfo="<table border='0' cellpadding='3'><tr><td>";
			PageInfo+="每页显示："+PerR+"/"+AllR+"条记录";
			PageInfo+="</td></tr></table>";
		}
	}
	

}
