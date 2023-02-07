/* 프로젝트, 기부자(Activist), 대상자(Recipient)가 미 존재할 경우 발생
 * 
 *  @ Author 김 혜 경
 */
package probono.exception;
/*
 * 사용자 정의 예외 클래스 개발방법
 * 1. exception을 상속 받는다
 * 2. 기본생성자 만들기
 * 3. super("String값") 가 포함된 상속받은 멤버변수 초기화 하는 생성자
 */

public class NotExistException extends Exception{
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
	}
}
