package main.DTO;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @ = anotation
// lombok : setter, getter, 생성자 자동 완성 (스프링뿐 아니라 자바, 어디서든 쓸 수 있음)
@Data // setter, getter
@AllArgsConstructor // 생성자
@NoArgsConstructor // 기본 생성자
*/
public class RegisterRequest {
	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isPasswordEqualConfirmPassword() {
		return password.equals(confirmPassword);
	}
}
