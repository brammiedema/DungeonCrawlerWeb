$(document).ready(function() {
	$("#inventory_jumbotron").toggle();
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

	$("#save").click(function(e) {

		$.get("api/save", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

	});

	$("#attack").click(function(e) {

		$.get("api/attack", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});

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

	$("#open_inventory").click(function(e) {
		$("#inventory_jumbotron").toggle();
		$('#inventory_content_weapons_table').DataTable().destroy();
		$('#inventory_content_consumables_table').DataTable().destroy();
		$('#inventory_content_armor_table').DataTable().destroy();
		initInventory();
	});

	function initWeapons(weapons) {

		$('#inventory_content_weapons_table').DataTable({
			data : weapons,
			columns : [ {
				"data" : "id",
				"visible" : false
			}, {
				"className" : "weapon_name",
				"data" : "name"
			}, {
				"data" : "type"
			}, {
				"data" : "maxDmg"
			}, {
				"data" : "minDmg"
			}, {
				"data" : "price",
			} ]
		});
	}

	function initConsumables(consumables) {
		$('#inventory_content_consumables_table').DataTable({
			data : consumables,
			columns : [ {
				"data" : "id",
				"visible" : false
			}, {
				"className" : "consumable_name",
				"data" : "name"
			}, {
				"data" : "type"
			}, {
				"data" : "effect"
			}, {
				"data" : "price"
			} ]
		});
	}

	function initArmor(armor) {
		$('#inventory_content_armor_table').DataTable({
			data : armor,
			columns : [ {
				"data" : "id",
				"visible" : false
			}, {
				"className" : "armor_name",
				"data" : "name"
			}, {
				"data" : "type"
			}, {
				"data" : "armor"
			}, {
				"data" : "price"
			} ]
		});
	}

	function initInventory(e) {
		$.get("api/inventory", function(data) {

			var dataObj = JSON.parse(data);
			initArmor(dataObj.armors);
			initWeapons(dataObj.weapons);
			initConsumables(dataObj.consumables);

		});
	}

	$("#move_south_button").click(function(e) {

		$.get("api/move?direction=south", function(data) {
			$("#game_input").append(data + "<br />");
			updateScroll();
		});
		$("#inventory_content").find("p:first").append(weaponDiv);

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

	target = "";

	$("#load").click(function(e) {
		$("#myModal").modal("show");
		target = "load";

	});

	$("#create").click(function(e) {
		$("#myModal").modal("show");

		target = "create";
	});

	$("#submit_name").click(function(e) {
		var name = $("#submit_name_value").val();

		$.get("api/" + target + "?name=" + name, function(data) {
			$("#game_input").append(data + "<br />");

		});
		target = undefined;
		$("#myModal").modal("hide");
		$("#submit_name_value").val = "";
		updateScroll();
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