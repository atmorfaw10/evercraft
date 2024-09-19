package com.accenture.boot.camp.evercraft;

import com.accenture.boot.camp.evercraft.model.CharacterSheet;
import com.accenture.boot.camp.evercraft.model.TargetAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class EvercraftApplicationTests {

	@Autowired
	private MockMvc mvc;
	public CharacterSheet newCharacter = new CharacterSheet("Edgar", "Good");

	@Test
	void person_endpoint_will_default_name_to_person_if_a_name_is_not_provided_as_a_request_param() throws Exception
	{
		// given the user does not provide a name in the request parameters

		// when we call the endpoint
		MvcResult result = mvc.perform(get("/person")).andReturn();
		// then the endpoint greets us as "World"
		Assertions.assertEquals(200, result.getResponse().getStatus());
		Assertions.assertEquals("Hello, World", result.getResponse().getContentAsString());
	}

	@Test
	void person_endpoint_will_greet_you_by_your_first_name_if_provided() throws Exception
	{
		// given the user provides their name in the request parameter
		String name = "Asong";

		// when we call the endpoint
		MvcResult result = mvc.perform(get("/person?name="+name)).andReturn();

		// then the endpoint greets us by name
		Assertions.assertEquals(200, result.getResponse().getStatus());
		Assertions.assertEquals("Hello, " + name , result.getResponse().getContentAsString());

	}

	@Test
	void new_character_possesses_attributes_with_default_values() throws Exception
	{
		// given the new character sheet has a name
		// when the character is initialized with the name

		// then the instance of the character has the expected name attribute
		String expectedName = "Edgar";
		Assertions.assertEquals(expectedName, newCharacter.getName());
	}

	@Test
	void new_character_posses_alignment_default_attribute_when_instantiated() throws Exception
	{
		// given there is a new Character Sheet
		// when the instance is called
		// then the instance of the character has the expected attribute "Good"
		String expectedAlignment = "Good";
		Assertions.assertEquals(expectedAlignment, newCharacter.getAlignment());
	}

	@Test
	void character_combatant_possesses_default_values_for_armor_class() throws Exception
	{
		// given a new Character Sheet
		// when I call the instance of the character
		// then the instance should possess the correct default attributes for armor class & hit points
		int expectedArmorClass = 10;
		int expectedHitPoints = 5;
		Assertions.assertEquals(expectedArmorClass, newCharacter.getArmorClass());
		Assertions.assertEquals(expectedHitPoints, newCharacter.getHitPoints());
	}

	@Test
	void die_roll_returns_a_valid_number() throws Exception
	{
		// given a new Character Sheet
		// when I roll the die
		// then the die roll will return a number between 1 and 20
		int expectedNonValidNumber = 21;
		int expectedValidNumber = 4;

		Assertions.assertEquals(expectedValidNumber, newCharacter.roll(expectedValidNumber));
		Assertions.assertEquals(-1, newCharacter.roll(expectedNonValidNumber));
	}


	@Test
	void character_meets_or_beats_target_character_armor_class_to_land_a_hit() throws Exception {
		// given a character is performing an attack
		CharacterSheet targetCharacter = new CharacterSheet("Kefka", "Evil");
		TargetAction attack = new TargetAction(newCharacter, targetCharacter);
		// When the die is rolled to attack a target
		// And the dieNumber returned is greater than or equal to the target's armorClass
		// Then the attack is successful
		int roll = newCharacter.roll(10);
		Assertions.assertTrue(attack.isSuccessfulRoll(roll));
	}

}
