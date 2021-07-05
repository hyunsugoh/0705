package com.sist.main;
/*
 *    메소드
 *      구현이 안된 메소드(추상메소드)
 *        public abstract 리턴형 메소드(매개변수...);
 *      구현이 된 메소드
 *        public 리턴형 메수드(매개변수...)
 *        {
 *        }
 *        => 필요하면 오버라이딩해서 사용, else 있는 그대로 사용가능 
 *        메소드는 {} 구현이 된다 
 *        
 *    인터페이스=> 스프링의 기본연결
 *    ======== 결함성을 낮게 만든다
 *    ** 추상클래스의 일(메소드가 거의 => 추상메소드, 변수는 상수형 변수)
 *    
 *    public interface Interface명
 *    {
 *      =========================
 *      변수:반드시 값을 지정해서 사용 => 상수형
 *      (public static final)int a=10;
 *       ====================생략 
 *      =========================
 *      메소드
 *      (public abstract) 리턴형 메소드(매개변수);
 *      =======모든 메소드는 public 
 *      =========================
 *      jdk1.8 설정 
 *      =========================
 *      구현이 가능한 메소드가 추가
 *      default메소드, static 메소드 
 *      public default 리턴형 메소드(매개변수)
 *      {
 *      }
 *      public static 리턴형 메소드(매개변수)
 *      {
 *      }
 *      =========================
 *    }
 *    
 *    내부클래스 : 윈도우, 네트워크, 쓰레드 
 *      멤버클래스 : 변수나 메소드를 두개이상의 클래스에서 쉽게 접근이 가능하게 제작 
 *        public class ClassName(윈도우)
 *        {
 *          =========================
 *          멤버변수 
 *          =========================
 *          메소드 
 *          =========================
 *          class ClassName(쓰레드) 
 *          {
 *            여기서 위에 있는 멤버변수, 메소드를 자유롭게 사용 가능
 *          }
 *          =========================
 *        }
 *        ==> 분석(MapReduce) : 데이터분석 (코모란, 꼬꼬마) 
 *        
 *      익명의 클래스: 상속이 없이 오버라이딩이 가능하게 만드는 클래스
 *        class A
 *        {
 *          public void display(){}
 *        }
 *        class B
 *        {
 *          public void display(){}를 재정의: 오버라이딩 
 *        }
 *        
 *        class A
 *        {
 *          public void display(){}
 *        }
 *        class B
 *        {
 *          A a=new A()
 *            {
 *              public void display(){} //오버라이딩
 *            }
 *        }
 *        문제 => 오류 (에러)
 *          오류를 방지하는 프로그램 : 예외처리 (조건문으로 사용) 
 *      
 *      예외처리와 관련된 클래스
 *        Check Exception: 컴파일시(javac) : 예외처리를 하지 않으면 컴파일시 에러가 발생
 *          Document doc=Jsoup.connection("URL").get();
 *        UnCheck Exception : 실행시(java) : 생략이 가능
 *      예외처리 구조(상속도): 예외처리도 순서가 있다
 *        Object : 모든 자바 클래스의 최상위
 *           |
 *        Throwsable
 *           |
 *        =============================
 *        |                           |
 *        Error					  Exception
 *        |								|
 *        OutOfMemoryError            ==========================
 *        메모리를 더이상 사용할수없다       |(uncheck)               |(check Exception)
 *                             RunTimeException              밑에서 계속 
 *                                    |생략이 가능한 에러 
 *                      ArrayIndexOutOfBoundsException
 *                        배열의 인덱스 초과
 *                        int[] arr=new int[2];
 *                        int[0]=10;
 *                        int[2]=20; => Error 배열 초
 *                      ArithmeticException
 *                        0으로 나눌 경우
 *                        int a=10/0;
 *                      NumberFormatException
 *                        String s="10";
 *                        정수형 변환이 안된다
 *                        Integer.parseInt(s); => 웹에서는 데이터 전송시: 문자열 : 1==> 오류: "1"이맞다 
 *                      ClassCastException
 *                        class A
 *                        class B
 *                        A a=new A();
 *                        B b=new B();
 *                        
 *                        b=(B)a; => CastException
 *                        관련이 없는 클래스는 형변환을 할 수 없다 : 1.상속 2.포함
 *                      NullPointerException
 *                       class A
 *                       {
 *                         public void display()
 *                         {
 *                         }
 *                       }
 *                       
 *                       A a; => NullPointerException
 *                         a는 참조변수: 주소가 없느 경우
 *                         클래스, 배열은 여러개를 동시에 제어 : 메모리 주소를 갖고 있어야한다 
 *                         a.display();
 *                         =====================================================================
 *                         Check Exception => 반드시 예외 처리를 한다 
 *                         ===============
 *                         컴파일러가 예외처리를 하는지 여부 확인(없는 경우에 바로 에러 출력)
 *                           1. IOException: 파일 입출력 
 *                                           ======== 파일 경로명.. 
 *                           2. MalformedURLException : URL주소 (네트워크)
 *                             URL 주소 틀리거나 서버주소가 틀릴경우 
 *                           3. SQLException : SQL문장이 틀린경우(오라클 연동)
 *                           4. InterruptedException : 쓰레드 충돌을 방지할때 사용
 *                             데들락, 스타베이션
 *                               쓰레드: 동기화, 비동기화 방식 두가지가 있음
 *                                 동기화 : 한개의 쓰레드가 작업을 종류후 다음 쓰레드가 동작
 *                               데들락: 쓰레드 작업하는 과정에서 멈추는 상태
 *                           5. ClassNotFoundException : 스프링 
 *              
 *            예외처리 방법 : 먼저 조건문으로 가능 여부 확인: 조건문으로 해결 불가: 예외처리 
 *              예외 복구(프로그래머가 처리) : 중간에 프로그램을 종료하지 않는 프로그램을 들 경우 사용
 *                예외 직접 처리 
 *                try ~ catch ~ finally  **
 *              예외 회피(시스템에 알려주는 방법)
 *                예외 간접 처리 
 *                throws ** 
 *              예외 전환
 *                임의로 발생 (에러를 일부로 발생: 프로그램이 견고한지 확인) : 배포 
 *                throw
 *              지원하지 않는 예외 : 사용자 정의 (예외처리를 제작할수있다) : if문 
 *              
 *              1. 직접 처리 형식 (try~catch)
 *              try
 *              {
 *              	평상시 만드는 모든 소스코드(정상적으로 수행 가능한 문장) 
 *              	=> 에러 발생 할 수 있다 
 *              }catch(예외처리의 종류)
 *              {
 *              	에러가 발생했을 경우 복구할 수 있는 소스코딩을 만든다 
 *              }
 *              finally
 *              {
 *              	생략이 가능
 *              	서버종료, 파일닫기, 데이터베이스 종료
 *              	try, catch와관련 없이 무조건 수행이 가능한 ㄴ장 
 *              }
 *              => 프로그램 전체를 예외처리 할 수도 있다
 *              => 부분적으로 처리도 가능 하다 (발생 가능한 위치에서 예외처리 가능)
 *              
 *              try
 *              {
 *                1문장
 *                2문장
 *                3문장
 *                4문장
 *                5문장
 *              }
 *              catch()
 *              {
 *                예외처리문장
 *              }
 *              
 *              
 *              1문장
 *              2문장
 *              try
 *              {
 *                3문장
 *                4문장
 *              }
 *              catch()
 *              {
 *                오류처리문장
 *              }
 *              5문장 
 *              
 *              ============ 
 *              1)
 *              try
 *              {
 *              	for(int i=0;i<=10;i++)
 *              	{
 *              		실행문장
 *              		=> i==5에서 에러발생 => catch로 이동 => 0, 1, 2, 3, 4까지 처리 이후 catch 가서
 *              	} 
 *              }catch()
 *              {
 *              	i==5,6,7,8,9,10 여기서 실행 
 *              }
 *              //catch가 for문 밖에있어서 에러나면 for문 밖 catch 가서 실행 
 *              
 *              2)
 *              for(int i=0;i<=10;i++)
 *              {
 *              	try
 *              	{
 *              		실행문장
 *              		=>i==5일때 에러발생 => catch로 이동 => 0,1,2,3,4 이후 catch 갔다가 5번 빼고 6,7,8,9,10 
 *              	}catch()
 *              	{
 *              		에러처리문장 
 *              		=> 증가식으로 이동 
 *              	}
 *              }
 */
public class 정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try
		{
			for(int i=1;i<=10;i++)
			{
				if(i==5)
				{
					System.out.println(i/0);
				}
				System.out.println("i="+i);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");*/
		
		for(int i=1;i<=10;i++)
		{
			try
			{
				if(i==5)
				{
					System.out.println(i/0);
				}
				System.out.println("i="+i);
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}System.out.println("프로그램 종료");
	}

}








