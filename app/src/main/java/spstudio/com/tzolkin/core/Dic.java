package spstudio.com.tzolkin.core;

import java.util.HashSet;
import java.util.Set;

public class Dic {
	public static String tones[][] = {
			{"MAGNETIC\n(磁性的)", "Unify(统一)", "Attracting(吸引)", "Magnetic(磁性的)", "Purpose(目的)"},
			{"LUNAR\n(月亮的)", "Polarize(二元化)", "Stabilizing(稳定)", "Lunar(月亮的)", "Challenge(挑战)"},
			{"ELECTRIC\n(电力的)", "Activate(启动)", "Bonding(结合)", "Electric(电力的)", "Service(服务)"},
			{"SELF-EXISTING\n(自我存在的)", "Define(定义)", "Measuring(测量)", "Self-Existing(自我存在的)", "Form(形式)"},
			{"OVERTONE\n(泛音的)", "Empower(强化)", "Commanding(命令)", "Overtone(泛音的)", "Radiance(放射)"},
			{"RHYTHMIC\n(韵律的)", "Organize(组织)", "Balancing(平衡)", "Rhythmic(韵律的)", "Equality(平等的)"},
			{"RESONANT\n(共鸣的)", "Channel(引导)", "Inspiring(启发)", "Resonant(共鸣的)", "Attunement(调和)"},
			{"GALACTIC\n(星系的)", "Harmonize(和谐)", "Modeling(塑造)", "Galactic(星系的)", "Integrity(整合)"},
			{"SOLAR\n(太阳的)", "Pulse(脉动)", "Realizing(实现)", "Solar(太阳的)", "Intention(意图)"},
			{"PLANETARY\n(行星的)", "Perfect(完美)", "Producing(产生)", "Planetary(行星的)", "Manifestation(显化)"},
			{"SPECTRAL\n(光谱的)", "Dissolve(溶解)", "Releasing(释放)", "Spectral(光谱的)", "Liberation(解放)"},
			{"CRYSTAL\n(水晶的)", "Dedicate(奉献)", "Universalizing(普遍化)", "Crystal(水晶的)", "Cooperation(合作)"},
			{"COSMIC\n(宇宙的)", "Endure(包容)", "Transcending(超越)", "Cosmic(宇宙的)", "Presence(存在)"}
	};
	
	public static String seals[][] = {
			{"RED DRAGON(lmix)", "Nurture(滋养)", "Being(存在)", "Input", "Birth"},
			{"WHITE WIND(lk)", "Communicate(沟通)", "Breath(气息)", "Input", "Spirit"},
			{"BLUE NIGHT(Akbal)", "Dream(梦)", "Intuition(直觉)", "Input", "Abundance"},
			{"YELLOW SEED(Kan)", "Target(目标)", "Awareness(觉知)", "Input", "Flowering"},
			{"RED SERPENT(Chicchan)", "Survive(生存)", "Instinct(本能)", "Store", "Life Force"},
			{"WHITE WORLD-BRIDGER(Cimi)", "Equalize(使平等)", "Opportunity(机会)", "Store", "Death"},
			{"BLUE HAND(Manik)", "Know(知晓)", "Healing(疗愈)", "Store", "Accomplishment"},
			{"YELLOW STAR(Lamat)", "Beautify(美化)", "Art(艺术)", "Store", "Elegance"},
			{"RED MOON(Muluc)", "Purify(净化)", "Flow(流动)", "Process", "Universal Water"},
			{"WHITE DOG(Oc)", "Love(爱)", "Loyalty(忠诚)", "Process", "Heart"},
			{"BLUE MONKEY(Chuen)", "Play(游戏)", "Illusion(幻象)", "Process", "Magic"},
			{"YELLOW HUMAN(Eb)", "Influence(影响)", "Wisdom(智慧)", "Process", "Free Will"},
			{"RED SKY-WALKER(Ben)", "Explore(探索)", "Wakefulness(觉醒)", "Output", "Space"},
			{"WHITE WIZARD(lx)", "Enchant(施魔力)", "Receptivity(接受)", "Output", "Timelessness"},
			{"BLUE EAGLE(Men)", "Create(创造)", "Mind(心智)", "Output", "Vision"},
			{"YELLOW WARRIOR(Cib)", "Question(提问)", "Fearlessness(无畏)", "Output", "Intelligence"},
			{"RED EARTH(Caban)", "Evolve(进化)", "Synchronicity(共时性)", "Matrix", "Navigation"},
			{"WHITE MIRROR(Etznab)", "Reflect(反射)", "Order(秩序)", "Matrix", "Endlessness"},
			{"BLUE STORM(Cauac)", "Catalyze(催化)", "Energy(能量)", "Matrix", "Self-Generation"},
			{"YELLOW SUN(Ahau)", "Enlighten(启发)", "Life(生命)", "Matrix", "Universal Fire"},
			
	};
	
	public static int guide[][] = {
			{1, 1, 13, 5, 17, 9},
			{2, 2, 14, 6, 18, 10},
			{3, 3, 15, 7, 19, 11},
			{4, 4, 16, 8, 20, 12},
			{5, 5, 17, 9, 1, 13},
			{6, 6, 18, 10, 2, 14},
			{7, 7, 19, 11, 3, 15},
			{8, 8, 20, 12, 4, 16},
			{9, 9, 1, 13, 5, 17},
			{10, 10, 2, 14, 6, 18},
			{11, 11, 3, 15, 7, 19},
			{12, 12, 4, 16, 8, 20},
			{13, 13, 5, 17, 9, 1},
			{14, 14, 6, 18, 10, 2},
			{15, 15, 7, 19, 11, 3},
			{16, 16, 8, 20, 12, 4},
			{17, 17, 9, 1, 13, 5},
			{18, 18, 10, 2, 14, 6},
			{19, 19, 11, 3, 15, 7},
			{20, 20, 12, 4, 16, 8}

	};
	
	public static Set<Integer> ge = new HashSet<Integer>();
	
	static{
		int[] d = new int[]{1,22,43,64, 85, 106, 107, 108, 109, 110, 111, 112, 113, 114,
				115, 88, 69, 50, 51, 72, 93, 96, 77, 58, 39, 20, 241, 222, 203, 184, 165,
				146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 168, 189, 210, 211, 192,
				173, 176, 197, 218, 239, 260};
		for (int i: d){
			ge.add(i);
		}
	}
}
