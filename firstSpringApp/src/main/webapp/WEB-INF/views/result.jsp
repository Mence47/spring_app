<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div>
            <p>Hello <%= session.getAttribute("last")%>
                    <%= session.getAttribute("name")%>
                    <%= session.getAttribute("middle")%>
            </p>
        </div>
    </body>
</html>