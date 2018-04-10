package dp.minipj.dpmini.models;

public class SignInResponse {

  private String email;
  private String image;
  private String nickname;
  private String phone;
  private Long userId;

  public SignInResponse() {
  }

  public SignInResponse(String email, String image, String nickname, String phone, Long userId) {
    this.email = email;
    this.image = image;
    this.nickname = nickname;
    this.phone = phone;
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
