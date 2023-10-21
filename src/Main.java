import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private int numbook = 0;
	private int numlibrarian = 0;
	private int nummember = 0;
	private ArrayList<Book> book = new ArrayList<>();
	private ArrayList<Librarian> librarian = new ArrayList<>();
	private ArrayList<Member> member = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	private void addLibrarian() {
		String name;
		do{
			System.out.print("Input Librarian's Name [ 5 - 25 Char ] : ");
			name = sc.nextLine();
			if(name.length() < 5 && name.length() > 25){
				System.out.println("Invalid, Try Again");
			}
			else break;
		}while(true);
		
		numlibrarian++;
		Integer id = numlibrarian;
		
		String password;
		do {
			System.out.print("Create Librarian's Password [There must be 1 Letter + 1 Number][5 - 10 Char] : ");
			password = sc.nextLine();
			Pattern pattern = Pattern.compile("[^\\w\\d]*(([0-9]+.*[A-Za-z]+.*)|[A-Za-z]+.*([0-9]+.*))");
			Matcher matcher = pattern.matcher(password);
			if(matcher.find() && password.length()>=5 && password.length()<=10) {
				break;
			}
			System.out.println("Invalid");
		}while(true);
		
		librarian.add(new Librarian(name,id,password));
	}
	
	private void addMember() {
		String mname;
		do{
			System.out.print("Input Member's Name [ 5 - 25 Char ] : ");
			mname = sc.nextLine();
			if(mname.length() < 5 && mname.length() > 25){
				System.out.println("Invalid, Try Again");
			}
			else break;
		}while(true);
		
		nummember++;
		Integer idm = nummember;
		
		member.add(new Member(mname,idm));
	}
	
	private void addBook() {
		numbook++;
		Integer isbn = numbook;
		
		String title;
		do{
			System.out.print("Input Book's Title : ");
			title = sc.nextLine();
			if(title.length() < 0){
				System.out.println("Invalid, Try Again");
			}
			else break;
		}while(true);
		
		String author;
		do{
			System.out.print("Input Author's Name [ 5 - 25 Char ] : ");
			author = sc.nextLine();
			if(author.length() < 5 && author.length() > 25){
				System.out.println("Invalid, Try Again");
			}
			else break;
		}while(true);
		
		book.add(new Book(isbn,title,author));
	}

	private void viewAllBook() {
		if(book.size() == 0) {
			System.out.println("No Book Available");
			return;
		}
		for(int i=0;i<book.size();i++) {
			Book curr = book.get(i);
			System.out.println("==========================================");
			System.out.println("Book's ISBN : " + curr.getIsbn());
			System.out.println("Title : " + curr.getTitle());
			System.out.println("Author : " + curr.getAuthor());
			System.out.println("Book's Status : " + curr.getStatus());
			System.out.println("==========================================");
		}
	}
	
	private void viewAllMember() {
		if(member.size() == 0) {
			System.out.println("No Member(s)");
			return;
		}
		for(int i=0;i<member.size();i++) {
			Member curr = member.get(i);
			System.out.println("==========================================");
			System.out.println("Member's ID : " + curr.getIdm());
			System.out.println("Name : " + curr.getMname());
			System.out.println("==========================================");
		}
	}
	
	private void deleteBook() {
		if(book.size() == 0) {
			System.out.println("No Book Available");
			return;
		}
		viewAllBook();
		int choice;
		do {
			System.out.print("Enter Book's ID you want to remove : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice <= book.size() && choice > 0) {
				book.remove(choice - 1);
				System.out.println("Success");
				break;
			}
			System.out.println("Invalid");
		}
		while(true);
	}
	
	private void deleteMember() {
		if(member.size() == 0) {
			System.out.println("No Member Data Available");
			return;
		}
		viewAllMember();
		int choice;
		do {
			System.out.print("Enter Member's ID you want to remove : ");
			choice = sc.nextInt();
			sc.nextLine();
			if(choice <= member.size() && choice > 0) {
				member.remove(choice - 1);
				System.out.println("Success");
				break;
			}
			System.out.println("Invalid");
		}
		while(true);
	}
	
	private void assign() {
		System.out.println("Available Book(s) :");
		
		if(book.size() == 0) {
			System.out.println("No Book Available");
			return;
		}
		
		boolean avb = false;
		
		for(Book b : book) {
			if(b.status()) {
				avb = true;
				System.out.println(b.getTitle());
			}
		}
			
		if(avb) {
			String title;
			do{
				System.out.print("Input Book's Title : ");
				title = sc.nextLine();
				
				if(title.length() < 0){
					System.out.print("Invalid, Try Again");
					continue;
				}
				
				boolean check = false;
				
				for(Book b : book) {
					if(title.equals(b.getTitle())) {
						check = true;
					}
				}
				
				if(check == false) {
					System.out.print("Book doesnt exist");
					return;
				}
				else break;
			}while(true);
			
			String mname;
			do{
				System.out.print("Input Member's Name [ 5 - 25 Char ] : ");
				mname = sc.nextLine();
				if(mname.length() < 5 && mname.length() > 25){
					System.out.println("Invalid, Try Again");
				}
				else break;
			}while(true);
			
			Integer idm;
			do {
				System.out.print("Input Member's ID : ");
				idm = sc.nextInt();
				sc.nextLine();
				if(idm > 0) {
					break;
				}
				System.out.println("Invalid");
			}while(true);
			
			boolean check = false;
			
			for(Member m : member) {
				if(mname.equals(m.getMname()) && idm == m.getIdm()){
					check = true;
					break;
				}
			}
			
			if(check == true) {
				for(Book b: book) {
					if(title.equals(b.getTitle())) {
						b.setMname(mname);
						b.setIdm(idm);
					}
				}
			}else {
				System.out.println("User doesnt exist");
			}
		}else {
			System.out.println("No Book Available");
		}
	}
	
	private void findBook() {
		if(book.size() == 0) {
			System.out.println("no book(s) currently");
			return;
		}
		
		System.out.println("Enter keyword");
		String keyword = sc.nextLine();
		
		int count = 0;
		
		for(Book b : book) {
			if(b.getTitle().equals(keyword) || b.getAuthor().equals(keyword) || b.getIsbn().toString().equals(keyword)) {
				System.out.println("==========================================");
				System.out.println("Book's ISBN : " + b.getIsbn());
				System.out.println("Title : " + b.getTitle());
				System.out.println("Author : " + b.getAuthor());
				System.out.println("Book's Status : " + b.getStatus());
				System.out.println("==========================================");
				count++;
			}
		}
		if(count>0) {
			System.out.println(count + " book(s) is found");
		}else {
			System.out.println("no book is found");
		}
	}
	
	private void findMember() {
		if(member.size() == 0) {
			System.out.println("no member(s) currently");
			return;
		}
		System.out.println("Enter keyword");
		String keyword = sc.nextLine();
		
		int count = 0;
		
		for(Member m : member) {
			if(m.getMname().equals(keyword) || m.getIdm().equals(keyword)) {
				System.out.println("==========================================");
				System.out.println("Member's ID : " + m.getIdm());
				System.out.println("Name : " + m.getMname());
				System.out.println("==========================================");
				count++;
			}
		}
		if(count>0) {
			System.out.println(count + " member(s) is found");
		}else {
			System.out.println("no member(s) is found");
		}
	}
	
	private void run() {
		while(true) {
			System.out.println("-------------------------");
			System.out.println("Library Management System");
			System.out.println("1. Add Librarian");
			System.out.println("2. Login Librarian");
			System.out.println("3. Exit");
			System.out.print("Your Choice: ");
			Integer ops;
			ops = sc.nextInt();
			sc.nextLine();
			switch (ops) {
			case 1:
				addLibrarian();
				break;
			case 2:
				Integer chname = 0;
				Integer chpass = 0;
				Integer iname = 0;
				Integer ipass = 0;
				String sname;
				System.out.print("Enter Librarian Name : ");
				sname = sc.nextLine();
				String spassword;
				System.out.print("Enter Librarian Password : ");
				spassword = sc.nextLine();
				
				for(int i=0;i<librarian.size();i++) {
					Librarian curr = librarian.get(i);
					if(sname.equals(curr.getName()) == true) {
						chname = 1;
						iname = i;
						break;
					}
				}
				
				for(int i=0;i<librarian.size();i++) {
					Librarian curr = librarian.get(i);
					if(spassword.equals(curr.getPassword()) == true) {
						chpass = 1;
						ipass = i;
						break;
					}
				}
				
				if(chname == 1 && chpass == 1 && iname == ipass) {
					do {
						System.out.println("-------------------------");
						System.out.println("Login Menu. Welcome!");
						System.out.println("1. Add Book");
						System.out.println("2. Add Member");
						System.out.println("3. View Book");
						System.out.println("4. View Member");
						System.out.println("5. Delete Book");
						System.out.println("6. Delete Member");
						System.out.println("7. Rent Book");
						System.out.println("8. Find Book");
						System.out.println("9. Find Member");
						System.out.println("10. Back");
						System.out.print("Your Choice: ");
						Integer opsi;
						opsi = sc.nextInt();
						sc.nextLine();
						switch (opsi) {
						case 1:
							addBook();
							break;
						case 2:
							addMember();
							break;
						case 3:
							viewAllBook();
							break;
						case 4:
							viewAllMember();
							break;
						case 5:
							deleteBook();
							break;
						case 6:
							deleteMember();
							break;
						case 7:
							assign();
							break;
						case 8:
							findBook();
							break;
						case 9:
							findMember();
							break;
						case 10:
							return;
						default:
							System.out.println("Option does not exist!");
							break;	
						}
					}while(true);
				}
				else {
					System.out.println("Wrong Password / Username");
				}
				break;
			case 3:
				return;
			default:
				System.out.println("Option does not exist!");
				break;
			}
		}
	}
}
