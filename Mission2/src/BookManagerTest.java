import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	public BookManager bookManager; 
	
	//Test를 위한 bookManager생성
	@BeforeEach
	void setUp() {
		bookManager = new BookManager();
	}
	
	//bookManager내의 addBook() Test
	@Test
	void testAddBook() {
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(1, "자바 기초", "Jane", 2021); //같은Book 생성 후 오류 메시지 확인
		bookManager.searchBook(1); //add 확인
	}
	
	//bookManager내의 searchBook() Test
	@Test
	void testSearchBook() {
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		bookManager.addBook(3, "분산 컴퓨팅", "Yoon", 2024);
		bookManager.searchBook(1);
		bookManager.searchBook(2);
		bookManager.searchBook(3);
		bookManager.searchBook(4); //오류 메시지 확인
	}

	//bookManager내의 deleteBook() Test
	@Test
	void testDeleteBook() {
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		bookManager.deleteBook(1);
		bookManager.deleteBook(1); //오류 메시지 확인
		bookManager.searchBook(1); //오류 메시지 확인
		
	}

}
