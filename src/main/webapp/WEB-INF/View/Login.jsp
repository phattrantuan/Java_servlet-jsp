<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Template_register/fonts/material-icon/css/material-design-iconic-font.min.css">
  <link rel="stylesheet" href="../Template_register/fonts/material-icon/css/material-design-iconic-font.min.css">
    <!-- Main css -->
  
      <link rel="stylesheet" href="${pageContext.request.contextPath}/Template_register/css/style.css">
                  <link rel="stylesheet" href="../Template_register/css/style.css">
</head>
<body>

    <div class="main">
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="${pageContext.request.contextPath}/Template_register/images/signin-image.jpg" alt="sing up image"></figure>
                        <a href="signupForward" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign In</h2>
                        <form method="POST" class="register-form" id="login-form" action="SignIn_Controller">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_name" id="your_name" placeholder="Your Name" value="<%=session.getAttribute("accountsession1")!=null?session.getAttribute("accountsession1"):""  %>"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password" value="<%=session.getAttribute("passwordsession")!=null?session.getAttribute("passwordsession"):""  %>"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term"  value="1" <%=session.getAttribute("checked")!=null?session.getAttribute("checked"):""  %>/>
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                        <div class="social-login">
                            <span class="social-label"></span>
                         
                                <a class="list-group-item" href="TestConnectionForward"><i class="zmdi zmdi-home zmdi-hc-fw"></i> Home</a>
                            
                        </div>
                    </div>
                                		
                </div>
                <div style="text-align: center"><%= request.getAttribute("msg")!=null?request.getAttribute("msg"):""  %></div> 
            </div>

        </section>

    </div>

    <!-- JS -->
    <script src="${pageContext.request.contextPath}/Template_register/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/Template_register/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>