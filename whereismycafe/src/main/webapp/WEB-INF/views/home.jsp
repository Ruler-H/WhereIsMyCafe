<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>WhereIsMyCafe</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-calable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link resl="stylesheet" href="assets/css/noscript" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="logo">
				<span class="icon fa-gem"></span>
			</div>
			<div class="content">
				<div class="inner">
					<h1>Where Is My Cafe</h1>
					<p>당신이 원하는 카페</p>
					<c:if test="${clientinfo == null}">
						<div id="login">
							<a href="client/join">고객 회원가입</a>&emsp; 
							<a href="client/login">고객 로그인</a></br>
							<a href="cafe/join">카페 회원가입</a>&emsp;
							<a href="cafe/login"> 카페 로그인</a>
						</div>
					</c:if>
					<c:if test="${clientinfo != null}">
						<img src="${pageContext.request.contextPath}/client/profile/${clientinfo.clientProfileImage}"/>${clientinfo.clientNickname}님</br>
						<a href="client/logout" class="menu">로그아웃</a>&emsp;
						<a href="client/update" class="menu">회원 정보 수정</a>
					</c:if>
					<c:if test="${cafeinfo != null}">
						<img src="${pageContext.request.contextPath}/cafe/profile/${cafeinfo.cefeLogo}" />${cafeinfo.cafeName} 점주님</br>
						<a href="cafe/logout" class="menu">로그아웃</a>&emsp;
						<a href="cafe/update" class="menu">카페 정보 수정</a>
					</c:if>
				</div>
			</div>
			<nav>
				<ul>
					<li><a href="#intro">Intro</a></li>
					<li><a href="cafe/search">Search</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<!--<li><a href="#elements">Elements</a></li>-->
				</ul>
			</nav>
		</header>
		<!-- Main -->
		<div id="main">

			<!-- Intro -->
			<article id="intro">
				<h2 class="major">Intro</h2>
				<span class="image main"><img
					src="${pageContext.request.contextPath}/images/pic01.jpg" alt="" /></span>
				<p>
					지원분야/회사에 지원하는 지원동기는?<br /> [다른 직무로부터 찾은 개발 직무]<br /> &emsp;전 직장에서
					송무 업무를 맡게 되면서 당시의 업무들이 무언가를 이루어가는 것이 아니라는 것을 느끼면서 다른 직무를 찾기 시작했습니다.
					여러 직무 중에서도 작은 부분부터 만들어가며 목표를 달성해 나아가는 개발자에 매력을 느껴 관심을 갖게 되었습니다.
					이전까지는 개발자 업무에는 어떠한 것들이 있는지 알지 못했지만 관심을 갖게 된 이후부터는 어떻게 배워야할 지를 알아보기
					시작했고, 많은 분야에서 사용되는 Java 언어를 사용하여 WebProgramming 및 앱 개발을 교육받을 수 있는
					과정을 이수하게 되었습니다. 과정을 이수하며 Spring을 활용한 Java 언어 활용 능력이 있고, Oracle 및
					My-SQL을 교육 받게 되었습니다. 또한 저는 제가 속한 회사의 목표를 위해서 추가적으로 필요한 개발 언어나 회사의
					사업에 필요한 업무 지식들을 계속해서 공부해가며 스스로의 성취를 이룰 것입니다. 그리고 이를 바탕으로 회사의 발전을
					도모하고, 회사를 성장시킬 것입니다. 또한 여기서 멈추는 것이 아니라 성장한 회사에서 다시 저의 성취를 이루고, 회사를
					성장시키는 지속적인 선순환의 중심이 될 것입니다. 이러한 저의 목표가 당 사 내에서도 긍정적 영향을 미칠 것이라
					생각합니다.
				</p>
				<p>
					지원분야에서 활용할 수 있는 직무 수행 경험은? <br /> [처음 만드는 나의 프로그램 제작]<br />
					&emsp;프로그래밍 공부를 시작하며, 제가 관심을 갖고 있는 분야를 선정하여 포트폴리오를 만들기 시작했습니다. Java
					언어를 기반으로 프로젝트를 시작하였고, Eclipse를 통합개발도구로 선정하였습니다. 중간 과정 중 Spring
					프레임워크로 전환하는 과정도 진행하였고, MySQL기반으로 구축하였던 데이터베이스를 Oracle로 변경하기도 했습니다.
					이러한 과정 등을 통해서 언어와 각 개발 도구들에 대한 활용 능력을 함양할 수 있었고, 프로젝트의 각 기능들을 구현하기
					위해 데이터베이스를 구축하고 서버의 DTO, DAO, Service, Controller 등 프로그래밍하면서 프로그램의
					처리 과정에 대해 더 면밀히 이해할 수 있었습니다. 물론 프로젝트 과정 중에는 많은 어려움이 있었습니다. 하지만
					포트폴리오는 결과물을 내는 것이 목적 중 하나이지만 결과물을 내는 과정에서 많은 오류 코드를 해결하면서 얻은 프로그래밍
					능력 또한 이 프로젝트의 목적이기 때문에 이 프로젝트를 통해서 프로그래밍에 필요한 많은 능력들을 갖출 수 있었다고
					생각합니다. 이 능력들을 통해서 입사한 후에도 많은 역량을 발휘할 것이고, 회사 내의 프로젝트를 통해서도 계속해서
					프로그래밍 능력을 향상시킬 수 있는 사원이 되도록 하겠습니다.
				</p>

				<p>
					입사 후 포부를 제시하고, 그에 따른 노력을 구체적으로 작성하시오.<br /> [오류를 줄이는 개발자]<br />
					&emsp;저는 개발자의 중요한 역량은 개발 중의 오류를 줄이는 것이라고 생각합니다. 좋은 기능을 개발하는 것도
					중요하지만 오류가 있다면 좋은 기능의 의미를 상실하는 것이라고 생각하기 때문입니다. 저는 이러한 오류들을 줄이기 위해서
					첫 번째로 맡은 업무의 도메인 지식에 대해서 집중할 것입니다. 개발자의 프로그래밍 역량도 중요하겠지만 맡은 프로젝트 관련
					도메인 지식에 대한 이해가 개발하는 프로그래밍의 오류를 줄이기 위한 중요 요소라고 생각하기 때문입니다. 이를 위해
					프로젝트의 요구사항에 집중하고, 사내 업무 담당자님들과의 지속적인 의사소통을 통하여 추가적인 요구사항이나 세밀한 기능의
					개발에서도 오류가 발생하지 않도록 하겠습니다. 두 번째로 개발 간의 모든 업무에서 진행 및 수정 등의 진행 상황을 상세히
					기록하여 같이 프로젝트를 진행하는 개발자님들 간의 커뮤니케이션을 활성화시켜 협업의 효과를 통해 저 뿐만이 아니라 같이
					프로젝트를 진행하는 팀의 오류 감소에 더하여 프로젝트 진행의 효율성을 높이도록 하겠습니다. 이러한 노력들로 입사 후에는
					제가 담당해야 할 컨텐츠 관련된 도메인 지식 습득을 위해 노력할 것입니다. 또한 사내로는 기존 개발자님들과 커뮤니케이션을
					지속적으로 유지하기 위해 노력할 것이고, 개발될 컨텐츠와 관련된 업무 담당자님들에게 피드백을 받아가며 배우려는 자세로
					일하는 직원이 되겠습니다.
				</p>
				<p>
					어렵거나 힘들었던 문제의 상황을 설명하고 어떠한 과정을 거쳐 해결하였는지 설명하시오.<br /> [문제를 인식하고 해결
					방법을 찾는 자세]<br /> &emsp;제가 6개월 동안 프로그래밍을 배우면서 이전까지 제가 공부하던 분야와는 많이
					다름을 느꼈습니다. 그 중 가장 큰 부분은 하나의 오류도 그 것을 알고 모름에 따라 그 코드에 걸리는 노력과 시간은
					개개인에 따라 천차만별이라는 것입니다. 저는 항상 어떠한 오류를 마주치더라도 포기하지 않고 끝까지 해결하려는 노력을
					하였고, 일례로는 한가지의 오류로 일주일을 해결하려 노력한 끝에 해결을 한 경험도 있습니다. 다른 사람이 보기에는
					효율적이지 못한 방법일 수도 있지만, 저는 이러한 프로그래밍에서의 노력을 단순한 효율성의 측면에서 보는 것이 아니라
					포기하지 않고 오류를 해결함으로써 꾸준히 본인의 프로그래밍 능력을 늘려가는 가며 추후에는 이러한 능력을 기반으로
					효율성까지 얻게 되는 것이 저의 장점이 될 것이라 생각하고, 이런 저의 자세는 당 사에서도 어떠한 어려운 문제가 있어도
					포기하지 않는 자세를 갖고 항상 해결 방법을 찾아내는 인재가 되어 문제 상황 속에서도 성공하는 당 사를 만들어
					가겠습니다.
				</p>
				<p>
					성격의 장/단점을 보여줄 만한 구체적인 사례를 작성하시오.<br /> [많은 경험으로 쌓아온 업무 적응과 고객 요구사항
					파악 능력]<br /> &emsp;20살부터 10개 이상의 아르바이트와 교내 동아리, 학회의 학회장, 군 내의 간부,
					교회의 엔지니어팀장 등을 하며 여러 업무에 대한 적응력을 키워왔습니다. 아르바이트에서는 서비스 업무, 동아리에서는 홍보
					업무, 학회에서는 학회장으로서 전체 총괄의 업무, 군 간부로서는 여러 인원을 관리하고 통솔하는 업무, 교회 팀장으로서는
					팀원들의 능력 향상을 포함하여 팀의 사역을 책임지는 일을 맡아왔습니다. 단순히 한 업무에 탁월한 능력보다는 어느 업무를
					맡더라도 배우려는 자세와 이전의 경험들을 통해 빠른 업무 적응을 할 수 있게 되었고, 이러한 저의 장점은 입사 후에도
					어떤 업무라도 빠른 업무 적응력을 통해 효율적인 인재가 될 것입니다. 또한 앞서 말씀을 드린 10개 이상의 아르바이트는
					모두 서비스와 관련된 업무로서, 많은 고객들을 상대하며 고객 요구사항에 대한 파악 능력을 함양할 수 있었고, 이는 컨텐츠
					사용자의 요구 사항을 빠르게 확인하여 그 요구사항을 서비스로 구현해내는 개발 직무에서 큰 도움이 될 거라고 생각합니다.
					<br />[암기력을 보충하기 위한 반복 체크의 습관]<br /> &emsp;저는 대학을 법학을 전공하여 다른
					학과보다도 암기력이 중요했습니다. 하지만 저의 암기력은 다른 학우들과 비교될 정도로 좋지 못했고, 항상 저의 기억력을
					보완하기 위해 반복하여 다시 확인하는 습관을 갖게 되었습니다. 이 습관은 단순히 공부에서만이 아니라 어느 업무와 직무를
					맡게 되어도 그 업무에 영향을 미쳐 왔습니다. 특히, 컨텐츠에서 어떤 서비스를 구현해야 하는지 명확히 해야 하는 개발
					업무에서는 저의 이러한 습관이 프로젝트의 목표를 향해 나아가는 과정에서 많은 이점을 가져올 것입니다.
				</p>
			</article>

			<!-- Work -->
			<article id="work">
				<h2 class="major">Search</h2>
				<span class="image main"><img
					src="${pageContext.request.contextPath}/images/pic02.jpg" alt="" /></span>
				<p>Adipiscing magna sed dolor elit. Praesent eleifend dignissim
					arcu, at eleifend sapien imperdiet ac. Aliquam erat volutpat.
					Praesent urna nisi, fringila lorem et vehicula lacinia quam.
					Integer sollicitudin mauris nec lorem luctus ultrices.</p>
				<p>Nullam et orci eu lorem consequat tincidunt vivamus et
					sagittis libero. Mauris aliquet magna magna sed nunc rhoncus
					pharetra. Pellentesque condimentum sem. In efficitur ligula tate
					urna. Maecenas laoreet massa vel lacinia pellentesque lorem ipsum
					dolor. Nullam et orci eu lorem consequat tincidunt. Vivamus et
					sagittis libero. Mauris aliquet magna magna sed nunc rhoncus amet
					feugiat tempus.</p>
			</article>

			<!-- About -->
			<article id="about">
				<h2 class="major">About</h2>
				<span class="image main"><img
					src="${pageContext.request.contextPath}/images/pic03.jpg" alt="" /></span>
				<p>Lorem ipsum dolor sit amet, consectetur et adipiscing elit.
					Praesent eleifend dignissim arcu, at eleifend sapien imperdiet ac.
					Aliquam erat volutpat. Praesent urna nisi, fringila lorem et
					vehicula lacinia quam. Integer sollicitudin mauris nec lorem luctus
					ultrices. Aliquam libero et malesuada fames ac ante ipsum primis in
					faucibus. Cras viverra ligula sit amet ex mollis mattis lorem ipsum
					dolor sit amet.</p>
			</article>

			<!-- Contact -->
			<article id="contact">
				<h2 class="major">Contact</h2>
				<form method="post" action="#">
					<div class="fields">
						<div class="field half">
							<label for="name">Name</label> <input type="text" name="name"
								id="name" />
						</div>
						<div class="field half">
							<label for="email">Email</label> <input type="text" name="email"
								id="email" />
						</div>
						<div class="field">
							<label for="message">Message</label>
							<textarea name="message" id="message" rows="4"></textarea>
						</div>
					</div>
					<ul class="actions">
						<li><input type="submit" value="Send Message" class="primary" /></li>
						<li><input type="reset" value="Reset" /></li>
					</ul>
				</form>
				<ul class="icons">
					<li><a href="#" class="icon brands fa-twitter"><span
							class="label">Twitter</span></a></li>
					<li><a href="#" class="icon brands fa-facebook-f"><span
							class="label">Facebook</span></a></li>
					<li><a href="#" class="icon brands fa-instagram"><span
							class="label">Instagram</span></a></li>
					<li><a href="#" class="icon brands fa-github"><span
							class="label">GitHub</span></a></li>
				</ul>
			</article>

			<!-- Elements -->
			<article id="elements">
				<h2 class="major">Elements</h2>

				<section>
					<h3 class="major">Text</h3>
					<p>
						This is <b>bold</b> and this is <strong>strong</strong>. This is <i>italic</i>
						and this is <em>emphasized</em>. This is <sup>superscript</sup>
						text and this is <sub>subscript</sub> text. This is <u>underlined</u>
						and this is code:
						<code>for (;;) { ... }</code>
						. Finally, <a href="#">this is a link</a>.
					</p>
					<hr />
					<h2>Heading Level 2</h2>
					<h3>Heading Level 3</h3>
					<h4>Heading Level 4</h4>
					<h5>Heading Level 5</h5>
					<h6>Heading Level 6</h6>
					<hr />
					<h4>Blockquote</h4>
					<blockquote>Fringilla nisl. Donec accumsan interdum
						nisi, quis tincidunt felis sagittis eget tempus euismod.
						Vestibulum ante ipsum primis in faucibus vestibulum. Blandit
						adipiscing eu felis iaculis volutpat ac adipiscing accumsan
						faucibus. Vestibulum ante ipsum primis in faucibus lorem ipsum
						dolor sit amet nullam adipiscing eu felis.</blockquote>
					<h4>Preformatted</h4>
					<pre>
						<code>i = 0;

while (!deck.isInOrder()) {
print 'Iteration ' + i;
deck.shuffle();
i++;
}

print 'It took ' + i + ' iterations to sort the deck.';</code>
					</pre>
				</section>

				<section>
					<h3 class="major">Lists</h3>

					<h4>Unordered</h4>
					<ul>
						<li>Dolor pulvinar etiam.</li>
						<li>Sagittis adipiscing.</li>
						<li>Felis enim feugiat.</li>
					</ul>

					<h4>Alternate</h4>
					<ul class="alt">
						<li>Dolor pulvinar etiam.</li>
						<li>Sagittis adipiscing.</li>
						<li>Felis enim feugiat.</li>
					</ul>

					<h4>Ordered</h4>
					<ol>
						<li>Dolor pulvinar etiam.</li>
						<li>Etiam vel felis viverra.</li>
						<li>Felis enim feugiat.</li>
						<li>Dolor pulvinar etiam.</li>
						<li>Etiam vel felis lorem.</li>
						<li>Felis enim et feugiat.</li>
					</ol>
					<h4>Icons</h4>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-github"><span
								class="label">Github</span></a></li>
					</ul>

					<h4>Actions</h4>
					<ul class="actions">
						<li><a href="#" class="button primary">Default</a></li>
						<li><a href="#" class="button">Default</a></li>
					</ul>
					<ul class="actions stacked">
						<li><a href="#" class="button primary">Default</a></li>
						<li><a href="#" class="button">Default</a></li>
					</ul>
				</section>

				<section>
					<h3 class="major">Table</h3>
					<h4>Default</h4>
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Item One</td>
									<td>Ante turpis integer aliquet porttitor.</td>
									<td>29.99</td>
								</tr>
								<tr>
									<td>Item Two</td>
									<td>Vis ac commodo adipiscing arcu aliquet.</td>
									<td>19.99</td>
								</tr>
								<tr>
									<td>Item Three</td>
									<td>Morbi faucibus arcu accumsan lorem.</td>
									<td>29.99</td>
								</tr>
								<tr>
									<td>Item Four</td>
									<td>Vitae integer tempus condimentum.</td>
									<td>19.99</td>
								</tr>
								<tr>
									<td>Item Five</td>
									<td>Ante turpis integer aliquet porttitor.</td>
									<td>29.99</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2"></td>
									<td>100.00</td>
								</tr>
							</tfoot>
						</table>
					</div>

					<h4>Alternate</h4>
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr>
									<th>Name</th>
									<th>Description</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Item One</td>
									<td>Ante turpis integer aliquet porttitor.</td>
									<td>29.99</td>
								</tr>
								<tr>
									<td>Item Two</td>
									<td>Vis ac commodo adipiscing arcu aliquet.</td>
									<td>19.99</td>
								</tr>
								<tr>
									<td>Item Three</td>
									<td>Morbi faucibus arcu accumsan lorem.</td>
									<td>29.99</td>
								</tr>
								<tr>
									<td>Item Four</td>
									<td>Vitae integer tempus condimentum.</td>
									<td>19.99</td>
								</tr>
								<tr>
									<td>Item Five</td>
									<td>Ante turpis integer aliquet porttitor.</td>
									<td>29.99</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="2"></td>
									<td>100.00</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</section>

				<section>
					<h3 class="major">Buttons</h3>
					<ul class="actions">
						<li><a href="#" class="button primary">Primary</a></li>
						<li><a href="#" class="button">Default</a></li>
					</ul>
					<ul class="actions">
						<li><a href="#" class="button">Default</a></li>
						<li><a href="#" class="button small">Small</a></li>
					</ul>
					<ul class="actions">
						<li><a href="#" class="button primary icon solid fa-download">Icon</a></li>
						<li><a href="#" class="button icon solid fa-download">Icon</a></li>
					</ul>
					<ul class="actions">
						<li><span class="button primary disabled">Disabled</span></li>
						<li><span class="button disabled">Disabled</span></li>
					</ul>
				</section>

				<section>
					<h3 class="major">Form</h3>
					<form method="post" action="#">
						<div class="fields">
							<div class="field half">
								<label for="demo-name">Name</label> <input type="text"
									name="demo-name" id="demo-name" value="" placeholder="Jane Doe" />
							</div>
							<div class="field half">
								<label for="demo-email">Email</label> <input type="email"
									name="demo-email" id="demo-email" value=""
									placeholder="jane@untitled.tld" />
							</div>
							<div class="field">
								<label for="demo-category">Category</label> <select
									name="demo-category" id="demo-category">
									<option value="">-</option>
									<option value="1">Manufacturing</option>
									<option value="1">Shipping</option>
									<option value="1">Administration</option>
									<option value="1">Human Resources</option>
								</select>
							</div>
							<div class="field half">
								<input type="radio" id="demo-priority-low" name="demo-priority"
									checked> <label for="demo-priority-low">Low</label>
							</div>
							<div class="field half">
								<input type="radio" id="demo-priority-high" name="demo-priority">
								<label for="demo-priority-high">High</label>
							</div>
							<div class="field half">
								<input type="checkbox" id="demo-copy" name="demo-copy">
								<label for="demo-copy">Email me a copy</label>
							</div>
							<div class="field half">
								<input type="checkbox" id="demo-human" name="demo-human" checked>
								<label for="demo-human">Not a robot</label>
							</div>
							<div class="field">
								<label for="demo-message">Message</label>
								<textarea name="demo-message" id="demo-message"
									placeholder="Enter your message" rows="6"></textarea>
							</div>
						</div>
						<ul class="actions">
							<li><input type="submit" value="Send Message"
								class="primary" /></li>
							<li><input type="reset" value="Reset" /></li>
						</ul>
					</form>
				</section>

			</article>

		</div>

		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>

	<!-- BG -->
	<div id="bg"></div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>



</body>
</html>