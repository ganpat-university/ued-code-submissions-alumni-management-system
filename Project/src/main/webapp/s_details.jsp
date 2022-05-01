<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="WEB-INF/taglib.tld" prefix="a"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="admin.css">
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
</head>
<body>
	<div class="sidebar">
		<div class="logo-details">
			<i class='bx bxl-redux'></i> <span class="logo_name">AdminPanel</span>
		</div>
		<ul class="nav-links">
			<li><a href="admin.jsp"> <i class='bx bx-grid-alt'></i>
					<span class="links_name">Dashboard</span>
			</a></li>
			<li><a href="#" class="active"> <i class='bx bx-box'></i> <span
					class="links_name">Student Details</span>
			</a></li>
			<li><a href="#"> <i class='bx bx-pie-chart-alt-2'></i> <span
					class="links_name">Register Alumni</span>
			</a></li>
			<li><a href="a_details.jsp"> <i class='bx bx-list-ul'></i> <span
					class="links_name">Alumni Details</span>
			</a></li>
			<li class="log_out"><a href="login.html"> <i
					class='bx bx-log-out'></i> <span class="links_name">Log out</span>
			</a></li>
		</ul>
	</div>
	<section class="home-section">
		<nav>
			<div class="sidebar-button">
				<i class='bx bx-menu sidebarBtn'></i> <span class="dashboard">Dashboard</span>
			</div>
			<div class="profile-details">
				<img src="red_ganpat_icon.png" alt=""> <span
					class="admin_name">Admin</span>
				<!-- <i class='bx bx-chevron-down' ></i> -->
			</div>
		</nav>

		<div class="home-content">
			
			<div class="sales-boxes">
				<div class="recent-sales box">
					<div class="title">Student Details</div>
					<div class="sales-details">
						<ul class="details">
							<%--  <a:db id=""></a:db>--%>
							<a:db1 table="student"></a:db1>
						</ul>
					</div>
				</div>
				</div>
			</div>
	</section>

	<script>
		let sidebar = document.querySelector(".sidebar");
		let sidebarBtn = document.querySelector(".sidebarBtn");
		sidebarBtn.onclick = function() {
			sidebar.classList.toggle("active");
			if (sidebar.classList.contains("active")) {
				sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
			} else
				sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
		}
	</script>

</body>
</html>
