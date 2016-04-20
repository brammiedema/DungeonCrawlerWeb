$(document).ready(function() {
	// ////////////
	// HANDLERS //
	// ////////////
	$("#menu-toggle").click(function(e) {
		e.preventDefault();

		if ($("sidebar-wrapper.toggled").is(":hidden")) {
			$("sidebar-wrapper.toggled").show();
		}

		$("#wrapper").toggleClass("toggled");

		if ($("sidebar-wrapper.toggled").is(":visible")) {
			$("sidebar-wrapper.toggled").hide();
		}

	});
	
	$("#move_north_button").click(function(e) {

		$.get("api/move?direction=north", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});
	$("#move_east_button").click(function(e) {

		$.get("api/move?direction=east", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});
	$("#move_west_button").click(function(e) {

		$.get("api/move?direction=west", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});
	$("#move_south_button").click(function(e) {

		$.get("api/move?direction=south", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});
	

	$("#look").click(function(e) {

		$.get("api/look", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});

	$("#directions").click(function(e) {

		$.get("api/directions", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});

	$("#load").click(function(e) {

		var id = prompt("Please enter your id", "1");
		if (id != null) {

			$.get("api/load/" + id, function(data) {
				$("#game_input").append(data + "<br />");
				updateScroll();
			});

		}

	});

	$("#logout").click(function(e) {

		$.get("api/logout", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});

	// /////////////
	// FUNCTIONS //
	// /////////////
	function updateScroll() {
		var element = document.getElementById("game_input_panel");
		element.scrollTop = element.scrollHeight + 2000;
	}

});