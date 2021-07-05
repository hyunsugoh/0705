package com.sist.main;
/*
 *   자바에서 지원하는 error 메세지
 *     getMessage(): 문자열로만 표시
 *     printStackTrace() : 실행되는 처리 과정을 보여준다
 *   
 *   멀티 catch
 *     catch(NumberFormatException | Array...Exception e) => | 를 사용하여 동시 처리 
 *     예외처리를 한번에 처리 할 경우에는 가장 큰 예외처리 클래스를 이용 
 *     catch(Exception e) => 예외처리 전체 복구 가능 
 *     catch(Throwable e) => Exception 전체, Error전체를 복구 할 수 있다 
 */
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			int a=10;
			int b=0;
			int c=a/b; //오류발생 => catch로 넘어가서 수행후 점프 
			System.out.println("c"+c); //수행을 못하는 문장 
		}catch(ArithmeticException e)
		{
			System.out.println(e.getMessage()); //어떤게 에러가 나왔는지 확인 : getMessage(); 
			e.printStackTrace(); //어디서 에러났는지 알려줌 
		}
	}

}
