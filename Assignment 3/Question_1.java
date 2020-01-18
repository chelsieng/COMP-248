//This program generates random passwords composed of words from selected pages from “Alice in Wonderland” by Lewis Carroll
import java.util.Random;

public class Question_1 {

	public static void main(String[] args) {
		// http://www.gutenberg.org/cache/epub/19033/pg19033.txt
		final String[][][] book = { { { "ALICE was beginning to get very tired of sitting by her sister on the\n",
				"bank, and of having nothing to do. Once or twice she had peeped into the\n",
				"book her sister was reading, but it had no pictures or conversations in\n",
				"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n", "conversations?\"\n" },
				{ "So she was considering in her OWN mind (as well as she could, for the\n",
						"day made her feel very sleepy and stupid), whether the pleasure of\n",
						"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n", "close by her.\n" },
				{ "There was nothing so very remarkable in that, nor did Alice think it so\n",
						"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
						"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
						"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
						"started to her feet, for it flashed across her mind that she had never\n",
						"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
						"out of it, and, burning with curiosity, she ran across the field after\n",
						"it and was just in time to see it pop down a large rabbit-hole, under\n",
						"the hedge. In another moment, down went Alice after it!" } },
				{ { "\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n", "telescope!\"\n" },
						{ "And so it was indeed! She was now only ten inches high, and her face\n",
								"brightened up at the thought that she was now the right size for going\n",
								"through the little door into that lovely garden.\n" },
						{ "After awhile, finding that nothing more happened, she decided on going\n",
								"into the garden at once; but, alas for poor Alice! When she got to the\n",
								"door, she found she had forgotten the little golden key, and when she\n",
								"went back to the table for it, she found she could not possibly reach\n",
								"it: she could see it quite plainly through the glass and she tried her\n",
								"best to climb up one of the legs of the table, but it was too slippery,\n",
								"and when she had tired herself out with trying, the poor little thing\n",
								"sat down and cried.\n" },
						{ "\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
								"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
								"herself very good advice (though she very seldom followed it), and\n",
								"sometimes she scolded herself so severely as to bring tears into her\n", "eyes.\n" },
						{ "Soon her eye fell on a little glass box that was lying under the table:\n",
								"she opened it and found in it a very small cake, on which the words \"EAT\n",
								"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
								"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
								"makes me grow smaller, I can creep under the door: so either way I'll\n",
								"get into the garden, and I don't care which happens!\"\n" },
						{ "She ate a little bit and said anxiously to herself, \"Which way? Which\n",
								"way?\" holding her hand on the top of her head to feel which way she was\n",
								"growing; and she was quite surprised to find that she remained the same\n",
								"size. So she set to work and very soon finished off the cake." } },
				{ { "The King and Queen of Hearts were seated on their throne when they\n",
						"arrived, with a great crowd assembled about them--all sorts of little\n",
						"birds and beasts, as well as the whole pack of cards: the Knave was\n",
						"standing before them, in chains, with a soldier on each side to guard\n",
						"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
						"and a scroll of parchment in the other. In the very middle of the court\n",
						"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
						"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n" },
						{ "The judge, by the way, was the King and he wore his crown over his great\n",
								"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
								"(some were animals and some were birds) I suppose they are the jurors.\"\n" },
						{ "Just then the White Rabbit cried out \"Silence in the court!\"\n" },
						{ "\"HERALD! read the accusation!\" said the King." } } };

		System.out.println("Welcome to the password generator game!\n");
		String password = "";
		Random rand = new Random(); // declaring random
		int page = 0; // page number
		int para = 0; // paragraph number
		int line = 0; // line number
		int count = 0; // passwords count
		int newLine = 0; // new line character count
		int single = 0; // single character count
		int equal = 0; // exact words count
		int length = 0; // password length count
		int upper = 0; // upper case character count
		int lower = 0; // lower case character count
		int special = 0; // only one special character count
		int specialCharCount = 0; // special characters in passwords count
		boolean invalid = false; // when password does not meet conditions
		while (true) {
			invalid = false;
			password = "";
			specialCharCount = 0;
			// generating 10000 passwords
			if (count == 10000) {
				break;
			}
			// Number of pages = 3
			page = rand.nextInt(3); // Obtaining page number between 0-2

			// There are 3 paragraphs in page 0
			if (page == 0) {
				para = rand.nextInt(3); // Obtaining paragraph number between 0-2

				if (para == 0 || para == 1) {
					line = rand.nextInt(5); // There are 5 lines in first and second paragraph on page 0

				} else if (para == 2) {
					line = rand.nextInt(9); // There are 9 lines in third paragraph on page 0

				}

			}
			// There are 6 paragraphs in page 1
			else if (page == 1) {
				para = rand.nextInt(6); // Obtaining paragraph number between 0-5

				if (para == 0) {
					line = rand.nextInt(2); // There are 2 lines in first paragraph on page 1

				} else if (para == 1) {
					line = rand.nextInt(3); // There are 3 lines in second paragraph on page 1

				} else if (para == 2) {
					line = rand.nextInt(8); // There are 8 lines in third paragraph on page 1

				} else if (para == 3) {
					line = rand.nextInt(5); // There are 5 lines in fourth paragraph on page 1

				} else if (para == 4) {
					line = rand.nextInt(6); // There are 6 lines in fifth paragraph on page 1

				} else if (para == 5) {
					line = rand.nextInt(4); // There are 4 lines in sixth paragraph on page 1

				}

			}
			// There are 4 paragraphs in page 2
			else if (page == 2) {
				para = rand.nextInt(4); // Obtaining paragraph number between 0-3

				if (para == 0) {
					line = rand.nextInt(8); // There are 8 lines in first paragraph on page 2

				} else if (para == 1) {
					line = rand.nextInt(3); // There are 3 lines in second paragraph on page 2

				} else if (para == 2 || para == 3) {
					line = rand.nextInt(1); // There is 1 line in third and fourth paragraph on page 2

				}
			}
			String chosen_line = book[page][para][line]; // Extracting line obtained from random

			String[] splitwords = chosen_line.split(" "); // Converting string into array of words

			// since password is composed of three words
			if (splitwords.length < 3) {
				continue;
			}
			String substring = "\n"; // newline character

			// Forming candidate password
			for (int i = 0; i < 3; i++) {
				int rand_word = rand.nextInt(splitwords.length); // choosing random word from array of words created
				String word = splitwords[rand_word]; // extracting random word
				// when random word is composed of only a single character
				if (word.length() == 1) {
					single++; // number of single character words generated
					invalid = true;
				}
				// when random word contains the newline character
				if (word.contains(substring)) {
					newLine++; // number of newline character words generated
					invalid = true;

				}
				// when two words are exactly the same
				if (password.contains(word)) {
					equal++; // number of exact words generated
					invalid = true;
				}

				password += word; // Concatenating three random words
			}
			// password must be at least 8 characters long and under 16 characters
			if (password.length() < 8 || password.length() >= 16) {
				length++; // number of passwords generated not meeting length count condition
				invalid = true;
			}
			// password must contain an upper case character
			if (password.equals(password.toUpperCase())) {
				lower++; // number of password generated not meeting upper case condition
				invalid = true;
			}
			// password must contain a lower case character
			if (password.equals(password.toLowerCase())) {
				upper++; // number of password generated not meeting lower case condition
				invalid = true;
			}
			// checking for special characters
			for (int j = 0; j < password.length(); j++) {
				if (!((password.charAt(j) >= 48 && password.charAt(j) <= 57)
						|| (password.charAt(j) >= 65 && password.charAt(j) <= 90)
						|| (password.charAt(j) >= 97 && password.charAt(j) <= 122))) {
					specialCharCount++; // counting number of special characters in password
				}

			}
			// password must contain only one special character
			if (specialCharCount > 1 || specialCharCount == 0) {
				special++; // number of password generated not meeting special character condition
				invalid = true;
			}

			// when password doesn't meet all conditions
			if (invalid == true) {
				continue;
			}
			// when password meets all conditions
			else {
				count++; // number of passwords generated meeting all conditions
				// formatting output
				System.out.printf(
						"Password = %-17s Newline = %-4d Single = %-4d Equal = %-4d Length = %-4d Upper = %-4d Lower = %-4d Special = %-4d\n",
						password, newLine, single, equal, length, upper, lower, special);
				// when lower case condition is reached
				if (lower != 0) {
					break;
				}
				// re initializing all conditions count after each password obtained
				newLine = 0;
				single = 0;
				equal = 0;
				length = 0;
				upper = 0;
				lower = 0;
				special = 0;

			}

		}
		System.out.println("\nTotal passwords generated: " + count);
		System.out.println("\nThanks for using the password generator game. Good bye.");
	}
}