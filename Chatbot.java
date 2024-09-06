//Develop an elementary Chabot for any suitable customer interaction application.

import java.util.*;

class Chatbot{
	private Map<String, List<String>> intents = new HashMap<>();
	
	public Chatbot(){
		intents.put("greetings", Arrays.asList("Hello! How can I assist you?", "HI! what brings you here?", "Hey, How can I help?"));
		
		intents.put("thanks", Arrays.asList("You're welcome!", "No Problem!", "Anytime!"));
		
		intents.put("goodbye", Arrays.asList("Goodbye! Have a great day!", "See you later!", "Bye for now!"));
		
		intents.put("help", Arrays.asList("How can I assist you?", "What do you need help with?", "I'm here here to help!"));
		
		intents.put("unknown", Arrays.asList("I didn't understand that.", "Could you please repharase?", "I'm not sure what you mean."));
	}
	
	public String matchIntent(String message){
					if(message.toLowerCase().contains("hello") || message.toLowerCase().contains("hi") || message.toLowerCase().contains("hey")) {
		return "greetings";
		}
		else if (message.toLowerCase().contains("thank you") || message.toLowerCase().contains("thanks")) {
		return "thanks";
		}
		else if (message.toLowerCase().contains("bye") || message.toLowerCase().contains("good bye")) {
		return "goodbye";
		}
		else if (message.toLowerCase().contains("help") || message.toLowerCase().contains("assistance")) {
		return "help";
		}
		else{
			return "unknown";
		}
	}
	public String getResponse(String intent){
		List<String> responses = intents.get(intent);
		return responses.get(new Random().nextInt(responses.size()));
		}
		
		public void chat(){
			System.out.println("Welcome to our customer support chatbot!");
			Scanner sc = new Scanner(System.in);
			while(true){
				System.out.print("User: ");
				String message = sc.nextLine();
				String intent = matchIntent(message);
				String response = getResponse(intent);
				System.out.println("Chatbot: " + response);
				if(intent.equals("goodbye")){
					break;
				}
			}
		}
		
	public static void main(String args[]){
		Chatbot cbt = new Chatbot();
		cbt.chat();
	}
}
