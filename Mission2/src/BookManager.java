import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class BookManager {
	public class Book implements Comparable<Book>{
		public int id;
		public String title;
		public String author;
		public int year;

		public Book(int ID, String Title, String Author, int Year) {	// Book 생성자
			super();
			this.id = ID;
			this.title = Title;
			this.author = Author;
			this.year = Year;
		}
		
		@Override
		public int compareTo(Book book) {	// Book 객체의 id 크기 비교
			if (this.id < book.id) {
				return -1;
			}
			else if (this.id == book.id) {
				return 0;
			}
			else {
				return 1;
			}
		}
		
		public void printBookInfo() {	// id로 library의 Book 정보 출력
			System.out.println("Book{id: '" + id + "', 제목: '" + title + "', 저자: '" + author + "', 출판년도: " + year + "}");
		}
	}

	ArrayList<Book> Library = new ArrayList<Book>();
	
	public void searchBook(int ID) {
		for (int i = 0; i < this.Library.size(); i++) {
			if (this.Library.get(i).id == ID) {
				System.out.println("검색결과:");
				this.Library.get(ID).printBookInfo();
				return;
			}	
		}
		
		
	}
	
	public void addBook(int ID, String Title, String Author, int Year) {
		Book book = new Book(ID, Title, Author, Year);
		// Library에 같은 id의 Book이 있는지 확인
		for (int i = 0; i <= this.Library.size(); i++) {
			if (this.Library.get(i).compareTo(book) == 0) {	// 같은 id 있으면 안내
				System.out.println("해당 ID(" + ID + ")는 이미 존재합니다.");
				return;
			}
		}
		// Library에 같은 id 없으면 book 추가
		this.Library.add(book);		
		Collections.sort(this.Library);		// Library 정렬
	}
	
	public void search_bs(int ID) {
		int last=this.Library.size()-1; //Library의 마지막 ID
		int first=0;                    //Library의 첫번째 ID
		
		while(first<=last) {
			
			int mid=(first+last)/2;   //중간값 계산
			
			if(ID == this.Library.get(mid).id) { //찾는 ID가 중간값과 동일
				System.out.println("검색결과:");
				this.Library.get(mid).printBookInfo(); //검색결과 출력
				return;
			}
			
			else if (ID < this.Library.get(mid).id) { //찾는 ID가 중간값보다 작다
				last=mid-1;           // 앞 부분 재탐색
			}
			else if(ID >this.Library.get(mid).id ) { //찾는 ID가 중간값보다 크다
				first=mid-1;          // 뒷 부분 재탐색
			}
		}
		System.out.println("해당 ID(" + ID + ")의 도서를 찾을 수 없습니다."); //찾는 ID가 없을 경우 출력
		return;
	}
	
	public void deleteBook(int ID) {
		for (int i = 0; i < this.Library.size(); i++) {	// Library에 같은 id의 Book이 있는지 확인
			if (this.Library.get(i).id == ID) {	// Library에 있으면 삭제
				this.Library.get(i).printBookInfo();
				System.out.println("도서를 삭제하였습니다.");
				this.Library.remove(i);		// Library에서 삭제 
				Collections.sort(this.Library);		// Library 정렬
				return;
			}		
		}	
		// Library에서 못 찾으면 안내
		System.out.println("해당 ID(" + ID + ")의 도서를 찾을 수 없습니다.");
	}
	
	/*
	Book[] library = new Book[10];	// Book 객체 배열

	public void addBook(int ID, String Title, String Author, int Year) {
		// library에 해당 id의 Book 객체 이미 있으면 안내
		if (library[ID] != null) {		  
			System.out.println("해당 ID(" + ID + ")는 이미 존재합니다.");
		}
		// library에 해당 id의 Book 객체 없으면 추가
		else {		
			library[ID] = new Book(ID, Title, Author, Year);
			library[ID].printBookInfo();
			System.out.println("도서가 추가되었습니다.");
		}		
	}

	public void searchBook(int ID) {	
		// 해당 Book 객체가 없거나 Book이 삭제된 경우
		if (library[ID] == null || library[ID].id == 0) {	
			System.out.println("검색된 도서가 없습니다.");
		}
		// 해당 Book이 있으면 검색결과 표시
		else {	
			System.out.println("검색결과:");
			library[ID].printBookInfo();	
		}
	}

	public void deleteBook(int ID) {
		// 해당 id의 Book 객체가 없거나 이미 삭제된 경우 안내
		if (library[ID] == null || library[ID].id == 0) {	
			System.out.println("해당 ID(" + ID + ")의 도서를 찾을 수 없습니다.");
		}
		// 해당 Book 있으면 삭제
		else {	
			library[ID].printBookInfo();
			System.out.println("도서를 삭제하였습니다.");
			library[ID].id = 0;
		}
	}
	*/
}
