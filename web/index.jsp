<%@ page import="util.Helper" %>
<%@ page import="java.io.File" %>
<%@ page import=" javax.servlet.http.HttpServletRequest" %>

<%--
  Created by IntelliJ IDEA.
  User: Twikura
  Date: 2018/12/2
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

  new Helper(request.getSession().getServletContext().getRealPath("/"));
  String path = request.getParameter("path");
  if(path==null||path.equals("")){
      path ="/";
  }
//    System.out.println(path);
String[] Pathes = Helper.getPathes(path);



%>
<html>
  <head>
    <title><%=path%></title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
      <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <style>

          body {
              font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
              font-size: 14px;
              line-height: 1.428571429;
              color: #333333;
              background-color: #f4ecd7;
          }


      </style>
  </head>
  <body>

  <div class="container">
      <div class="row clearfix">
          <div class="col-md-12 column">
              <div class="page-header">
                  <h1>
                      <%=path%>
                  </h1>
              </div>
          </div>
      </div>
  </div>

  <div class="container">
  <%
      for(String p : Pathes){
  %>
      <div class="row clearfix">
          <div class="col-md-6 col-md-offset-3 column">
              <a href="<%=p%>"><%=Helper.getFileName(p)%></a><br>
          </div>
      </div>

  <%
      }
  %>
  </div>
  </body>

</html>
