package com.jojoldu.book.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
								// setter을 안쓰는 이유는 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 구분하기 어려워서
@Getter							// 대신 목적과 의도를 나타낼수 있는 메소드를 추가해줘야함 (setstatus() x  / cancelOrder() o).
@NoArgsConstructor				// 기본생성자 자동추가 : public Posts() {} 와 같은 효과.
@Entity							// 테이블과 링크될 클래스.
public class Posts {
	
	@Id							// Primary Key(PK).
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//PK 생성규칙 , GenerationType.IDENTITY => auto_increment.
	private Long id;
	
								// 주민등록번호나 복합키 등은 유니크키로 별도로 추가하는걸 추천함.
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	@Builder					// 빌더 패턴 클래스 생성 (생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함)
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	
	
								// PostsRepository.java 파일은 posts(Entity 클래스)랑 같은 곳에 있어야 한다는데 맞나?
	
	
	
}
