package study.ssg.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		
		List<Article> articles = new ArrayList<>();
		
		System.out.println("== 프로그램 시작 ==");
		System.out.println("종료 -> system exit");
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.printf("명령어 입력: ");
			String command = sc.nextLine();
			
			if (command.equals("article write")) {
				
				System.out.printf("제목: ");
				String title = sc.nextLine();
				
				System.out.printf("내용: ");
				String body = sc.nextLine();
				
				Article article = new Article(title, body);
				articles.add(article);
				
				System.out.println(article.articleId + "번 게시물이 작성되었습니다.");
				
			}
		
			else if (command.equals("article list")) {
				
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}
				
				System.out.println("번호 / 제목");
				
				for (Article article : articles) {
					System.out.printf("%4d / %s\n", article.articleId, article.title);
				}
				
			}
			
			else if (command.startsWith("article detail ")) {
				
				String input = command.substring("article detail ".length()).trim();
				
				if (input.equals("")) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
				
				boolean cmdCheck = input.matches("-?\\d+");
				
				int foundId = 0;
				if (cmdCheck) {
					foundId = Integer.parseInt(input);
				} else {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.articleId == foundId) {
						foundArticle = article;
					}
				}
				
				if (foundArticle != null) {
					System.out.println("번호: " + foundArticle.articleId);
					System.out.println("제목: " + foundArticle.title);
					System.out.println("내용: " + foundArticle.body);
					System.out.println("===========");
				} else {
					System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
			} else if (command.startsWith("article modify ")) {
				
				String input = command.substring("article modify ".length()).trim();

				if (input.equals("")) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				boolean cmdCheck = input.matches("-?\\d+");

				int foundId = 0;
				if (cmdCheck) {
					foundId = Integer.parseInt(input);
				} else {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.articleId == foundId) {
						foundArticle = article;
					}
				}
				
				if (foundArticle != null) {
					
					System.out.printf("제목: ");
					String title = sc.nextLine();
					
					System.out.printf("내용: ");
					String body = sc.nextLine();
					
					foundArticle.title = title;
					foundArticle.body = body;
					
					System.out.println(foundArticle.articleId + "번 게시물이 수정되었습니다.");
					
				} else {
					System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
			} else if (command.startsWith("article delete ")) {
				
				String input = command.substring("article delete ".length()).trim();

				if (input.equals("")) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				boolean cmdCheck = input.matches("-?\\d+");

				int foundId = 0;
				if (cmdCheck) {
					foundId = Integer.parseInt(input);
				} else {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				Article foundArticle = null;

				for (Article article : articles) {
					if (article.articleId == foundId) {
						foundArticle = article;
					}
				}
				
				if (foundArticle != null) {
					
					articles.remove(foundArticle);
					System.out.println(foundArticle.articleId + "번 게시물이 삭제되었습니다.");
					
				} else {
					System.out.println(foundId + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
			} else if (command.equals("system exit")) {
				
				System.out.println("시스템을 종료합니다.");
				break;
				
			} else {
				
				System.out.println("잘못된 명령어입니다.");
				
			}
			
		}
		

	}
}

class Article {
	static int index = 0;
	int articleId;
	String title;
	String body;
	
	Article(String title, String body) {
		this.title = title;
		this.body = body;
		this.index++;
		this.articleId = this.index;
	}
}