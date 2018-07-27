package kr.or.ddit.file;

public class FileUtil {

	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload";

	/**
	 * 
	 * Method : getFileName
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 :part의 Content-Disposition header로 부터 업로드 파일명을 리턴한다.
	 * 
	 * ex:form data; name="uploadFile"; filename="sally.png"
	 * 		return : sally.png
	 */
	//"form-data; name=\"uploadFile\"; filename=\"Koala.jpg"
	/*
	public String getFileName(String contentDisposition){
		System.out.println(contentDisposition);
		String[] cdSplit = contentDisposition.split("; ");
		//cdSplit[0] : form-data, 
		//cdSplit[1] : name="uploadFile", 
		//cdSplit[2] : filename="Koala.jpg"
		String result = "";
		System.out.println(cdSplit.length);
		String[] cdSplit2 = new String[cdSplit.length+1];
		for(int i = 0; i <= cdSplit.length; i++){
			cdSplit2 = cdSplit[i].split("=");
			System.out.println(i + "번째" + cdSplit2[i]);
			if(cdSplit2[1].equals("Koala.jpg")){
				result = cdSplit2[1];
			}
		}
		return "";
	}
	 */

	public static String getFileName(String contentDisposition){
		// cookie : userId=brown; rememberMe=y
		String[] cdSplit = contentDisposition.split("; ");
		String fileName = "";
		for (String str : cdSplit) {
			if(str.startsWith("filename")){
				fileName = str.substring("filename".length()+2,str.length()-1);
				break;
			}
		}
		return fileName;
	}
}
