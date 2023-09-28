package com.jdbc.util;

public class MyUtil {
	
	//��ü��������                           
	public int getPageCount(int numPerPage, int dataCount) {
		
		int pageCount = 0;
		pageCount = dataCount / numPerPage;
		
		if(dataCount%numPerPage!=0) {
			pageCount++;
		}
		
		return pageCount;
	}
	
	//������ ó��
	public String pageIndexList(int currentPage, int totalPage, 
			String listUrl) {
		
		int numPerBlock = 5;//������  6  7  8  9  10  ������ 6~10������ ����
		int currentPageSetup;//������ <-�̰�
		int page;//6,7,8,9,10 �� ���� ���� ���ڰ�. �ϸ� for���� i
		
		StringBuffer sb = new StringBuffer();
		
		if(currentPage==0 || totalPage==0) {
			return "";
		}
		
		//listUrl�� list.jsp���� �־���.
		//�˻�X = list.jsp
		//�˻�O = list.jsp?searchKey=subject&serachValue=3
		
		//?�� �ִٸ�(�˻��� �ߴٸ�) &�� �ٿ��ְ� -> list.jsp?searchKey=subject&serachValue=3&
		//�ƴ϶��(�˻��� ���� �ʾҴٸ�) ?�� �ٿ��ش�. -> list.jsp?
		//�׷��� �ڿ� pageNum�� ���� �� �ִ�
		if(listUrl.indexOf("?")!=-1) {
			listUrl = listUrl+"&";
		}else {
			listUrl = listUrl+"?";
		}
		
		//ǥ���� ù �������� -1 ���� ��
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		//�� �������� �� ���� ��ġ�� ����
		if(currentPage%numPerBlock==0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		//currentpage 10 numperblock 5
		//�̷��� �ϸ� ���� 10 ����
		//�׷��� if�� currentpagesetup = 10-5 => 5
		//�̷��� "������" �̰��� 5�� ����
		
		//        1  2  3  4  5  ������
		//������  6  7  8  9  10  ������
		//������  11  12 
		
		//"������" ����� ����
		if(totalPage>numPerBlock && currentPageSetup>0) {
			sb.append("<a href=\"" + listUrl + "pageNum=" + 
					currentPageSetup + "\">������</a>&nbsp;");
			//<a href="list.jsp?pageNum=5">������</a>&nbsp;
		}
		
		//�ٷΰ��� ������( 1 2 3 4 5 ...) �̺κ� �����
		page = currentPageSetup + 1;
		
		while(page<=totalPage && page<=(currentPageSetup+numPerBlock)) {
			
			if(page==currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + 
						"</font>&nbsp;");
				//<font color="Fuchsia">1</font>&nbsp;
			}else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + 
						page + "\">" + page + "</a>&nbsp;");
				//<a href="list.jsp?pageNum=2">2</a>&nbsp;
			}
			page++;
		}
		
		//"������"����� ����
		if(totalPage-currentPageSetup>numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + 
					page + "\">������</a>&nbsp;");
			//<a href="list.jsp?pageNum=6">������</a>&nbsp;
		}
		
		return sb.toString();
	}
}
	
