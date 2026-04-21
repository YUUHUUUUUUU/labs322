import java.util.HashMap;
import java.util.Map;

public class CardFactory {
    private Map<String, Card> cardTemplates = new HashMap<>();

    CardFactory(){
        // NOTE: Changing the keys used in the map breaks the decks creation. The keys here should be
        // treated as FIXED IDS

        // Effects
        Effect coffe  = new EnergyEffect("Coffe", "Regenerates Energy", 3, 15);
        Effect H5N1 = new PoisonEffect("H5N1", "Bird Flu", 2, 20); //IB
        Effect poison = new PoisonEffect("Poison", "Generic Poison Damage", 3, 10);
        Effect mercuryPoisoning = new PoisonEffect("Mercury Poisoning", "Sicness caused by a slightly poisonous metal",2,15);
        Effect radiationSickness = new PoisonEffect("Radiation Sickness", "Damage caused by radiation, makes your cells die from the inside",3,25);

        // General Cards
        cardTemplates.put("Coffe", new CardEffect("energy buff", "regenerates energy", 4, coffe));

        // Hero Cards
        cardTemplates.put("Ruler", new CardDamage("Ruler","Strong attack", 5, 40));
        cardTemplates.put("Pencil", new CardDamage("Pencil","Medium attack",4,30));
        cardTemplates.put("Eraser", new CardDamage("Eraser","Weak attack", 3, 20));

        cardTemplates.put("Excused Absence", new CardShield("Excused Absence","Weak defense", 2, 10));
        cardTemplates.put("Doctor's note", new CardShield("Doctor's Note","Medium defense",3,20));
        cardTemplates.put("Exam Exemption", new CardShield("Exam Exemption","Strong defense", 4, 30));
        cardTemplates.put("Summer Break", new CardShield("Summer Break","Ultimate defense", 10, 100));

        cardTemplates.put("Poisoned Apple", new CardEffect("Poisoned Apple", "A poisoned gift", 3, poison));

        // Institute Cards
        cardTemplates.put("Test", new CardDamage("Test","Weak attack",2, 10));
        cardTemplates.put("Exam", new CardDamage("Punch", "Medium attack", 3, 15));
        cardTemplates.put("Final Exam", new CardDamage("Final Exam", "Strong attack", 6,35));
        
        cardTemplates.put("Cancel Classes", new CardShield("Cancel Classes","Weak defense", 2, 10));
        cardTemplates.put("Public Servant Immunity", new CardShield("Public Servant Immunity","Strong defense", 4, 30));
        cardTemplates.put("Paid Leave", new CardShield("Paid Leave","Ultimate defense", 10, 100));

        // IFGW Cards
        cardTemplates.put("Mercury Termometer", new CardDamage("Mercury Termometer", "Medium attack, but with poison", 7, 20, mercuryPoisoning));
        cardTemplates.put("Atomic Blast", new CardDamage("Atomic Blast", "Huge explosion caused by fission",7,100));

        cardTemplates.put("Radium", new CardEffect ("Radium", "Powder of a rafioactive material",6, radiationSickness));

        //IB Cards... etc
    }

    Card getCard(String name){
        return cardTemplates.get(name);
    }
}
