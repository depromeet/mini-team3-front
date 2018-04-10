package dp.minipj.dpmini.models;

import java.io.Serializable;

public class SignUpRequest implements Serializable {

  private String email;
  private String image;
  private String nickname;
  private String password;
  private String phone;

  public SignUpRequest() {
  }

  public SignUpRequest(String email, String image, String nickname, String password, String phone) {
    this.email = email;
    this.image = image;
    this.nickname = nickname;
    this.password = password;
    this.phone = phone;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
