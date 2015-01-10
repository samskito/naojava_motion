package posture;

import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALRobotPosture;

public class PostureClass {
	public static void main(String[] args) throws Exception {
		ALTextToSpeech tts;
		ALMotion motion;
		Session session = new Session();
		Future<Void> fut = session.connect("tcp://ned.local:9559");
		fut.get();

		tts = new ALTextToSpeech(session);
		tts.setLanguage("French");
		tts.say("Bonjour à tous, je suis Nao. Je vais maintenant me lever");
		
		motion = new ALMotion(session);
 		motion.wakeUp();
		
		ALRobotPosture posture = new ALRobotPosture(session);
		posture.goToPosture("StandInit", (float)1.0);
		
		motion.rest();
	}
}