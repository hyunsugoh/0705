package com.sist.main;
/*
 *   예외처리 : 예상되는 에러를 복구해서 사용이 가능 (정ㅇ상적으로 수행이 가능)
 *   예)
 *     사용자로부터 정수를 받아서
 *     배열에 저장한 다음에 두개의 정수를 나눈값을 출력 
 *     ===        				  ====
 *     배열은 인덱스 초과			  사용자가 0으로 나눠달라 할 수 있음 
 *     => 이 두가지가 예외처리 
 *       두가지: catch절 2개 => try 한개에 catch절 여러개 사용이 가능 
 *          계층구조:
 *                              Object
 *                                |
 *                              Throwable
 *                                |
 *                           =================
 *                           |               |
 *                         Error          Exception(처리ㅐ가 가능한 부분)
 *                          				 |
 *                                     ============================
 *                                     | 반드시 예외처리               |
 *                                   컴파일에러                   실행시에러   
 *                                                            RunTimeException
 *                                                                |
 *                                                      ArrayIndexOutOBoundsException
 *                                                      ArithmeticException
 *                                                      NumberFormatException 
 *      
 *     1) 
 *     try
 *     {
 *     }catch(ArrayIndexOutOfBoundsException) 배열은 인덱스 초과
 *     {
 *     }catch(ArithmeticException) 사용자가 0으로 나눠달라 할 수 있음 
 *     {
 *     } 
 *     
 *     2) 
 *     try
 *     {
 *     }catch(Exception) 배열은 인덱스 초과, 사용자가 0으로 나눠달라 할 수 있음 (예외와 관련된 모든 예외를 받을 수 있다) 
 *     {
 *     }
 *     
 *     3)
 *     try
 *     {
 *     }catch(Throwable)
 *     {
 *     } 
 *     
 *     4)
 *     try
 *     {
 *       정상 수행이 가능한 소스코딩(평상시코딩)
 *     }catch(Exception) //기타 ======> 문법상 오류 
 *     {
 *     }
 *     catch(ArrayIndexOutOBoundsException) //배열 
 *     {
 *     }catch(ArithmeticException) // 나누기
 *     {
 *     }
 *     ==>catch 설정하는 예외처리 종류는 순서가 있다 (작은것에서 큰것으로) 
 *     
 *     
 *     try~catch에 실행순
 *     try
 *     {
 *       1문장 정상 
 *       2문장 정상
 *       3문장 정상
 *       4문장 정상
 *       5문장 정상 ==> 모두 정상이니까 catch를 통과해서 수행 
 *         //만약 4문장에서 오류나면 캐치로 이동, 4,5는 수행되는 문장이 아니게된다 : 1,2,3,6,7만 수행 
 *     }
 *     catch(Exception e)
 *     {
 *       6문장 => 에러복구 => 에러(수정위치 확인)
 *       => 에러메세지 출력
 *       =>getMessage() => /zero 
 *         printStackTrace() => 에러위치 확인(권장) 
 *     } 
 *     7문장 
 *     ==========> 1,2,3,4,5, 7문장 수행 
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("문장1");
		System.out.println("문장2"); //예외와 관련이 없고 무조건 수행하는 문장 
		try
		{
			System.out.println("문장3");
			int[] arr= {10,5};
			System.out.println(arr[0]/arr[1]);
			System.out.println(Integer.parseInt("30")); //공백이 있어서 정수변환이 안됨: 공백지우면 됨 
			MainClass2 m=null; //new를 이용해서 저장공간을 만든다 (null은 저장공간이 없는상태) 
			System.out.println(m.toString());
			Object obj=new MainClass2();
			m=(MainClass2)obj;
			System.out.println(m);
			//형변환시에는 반드시 생성자가 동일해야 함 
			System.out.println("정상수행 => catch절은 수행하지 않는다");
		}
		//RuntimeException : 실행시 에러 : 전체를 다 통합
		//catch절은 1개만 수행 
		catch(ArrayIndexOutOfBoundsException e) //배열범위 초과했을 경우만 수행
		{
			System.out.println("배열 범위 초과 에러 발생");
		}catch(ArithmeticException e) //0으로 나눌 경우 수행
		{
			System.out.println("0으로 나눌 수 없음");
		}catch(NumberFormatException e) //문자열을 정수형으로 변경이 안될 경우 "aaa" "A"
		{
			System.out.println("정수형 변환 불가능");
		}catch(NullPointerException e) //객체주소나 배열에 주소가 없는 경우
		{
			System.out.println("객체나 배열의 주소가 없음");
		}catch(ClassCastException e) //클래스 형변환 문제 
		{
			System.out.println("클래스 형변환 에러 발생");
		}
		catch(RuntimeException e) //예상하지 못한 기타 에러 //이게 제일 큰것이여서 맨 밑에 나와야한다 //맨위에 두면 오류  
		{
			System.out.println("기타 에러 처리"); //위에서 하나 빠져도 마지막에 여기서 잡아줌 
		}
		System.out.println("프로그램 종료");
		//해당 catch절이나 RunTimeException이 없으면 비정상종료가 뜬다 
	}

}






