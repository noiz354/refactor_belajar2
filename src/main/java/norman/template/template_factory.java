package norman.template;

import norman.hackerrank.AVeryBigSum;
import norman.hackerrank.CountLuck;
import norman.hackerrank.DiagonalDifference;
import norman.hackerrank.EvenTree;
import norman.hackerrank.GridChallenge;
import norman.hackerrank.IntroSorting;
import norman.hackerrank.JourneyToTheMoon;
import norman.hackerrank.PascalTriangle;
import norman.hackerrank.PrimMSTSpecialSubTree;
import norman.hackerrank.QuickSortInPlace;
import norman.hackerrank.ReformatTheDate;
import norman.hackerrank.RustMurderer;
import norman.hackerrank.ShortestReach;
import norman.hackerrank.VisitedCell;
import norman.srin.algorithm.BiColoring;
import norman.srin.algorithm.Bomberman;
import norman.srin.algorithm.BugHunters;
import norman.srin.algorithm.CellRemoval;
import norman.srin.algorithm.Evenfibo;
import norman.srin.algorithm.HighestPeak;
import norman.unknown.BSTExample;
import norman.unknown.DFSCyclicLearn;
import norman.unknown.HMacTokopedia;
import norman.uva.*;
import norman.uva.Battleships;

public abstract class template_factory {
	public final static int
			dynamic_programming = 1,
			greedy = 2,
			backtrack = 3,
			recursive_backtrack = 4,
			graph = 5,
			srin_sotong = 6,
			uva = 7
			,hackkerank = 8,
			sorting = 9,
			unknown = 10;

	public final static int bomberman = 1, bughunter = 2, backtoeightqueens = 3, callforwarding = 4, cd = 5
			, cellRemoval = 6, chestOfDrawers = 7, countLuck =8, division = 9, dominator = 10, dragonofloowater = 11
			, eightqueenproblem = 12, evenfibo = 13, eventree = 14, expertEnough = 15, granddiner = 16
			, grapevine = 17, gridchallenge = 18, hammingdistance = 19, hanoitowerproblemagain = 20, highestpeak = 21
			, introsorting = 22, quicksortinplace = 23, averybigsum = 24, diagonaldifference = 25, reformatthedate =26
			, visitedcell = 27, pascaltriangle = 28, bicoloring = 29, wetlandofflorida = 30, shortestreach = 31
			, rushmurderer = 32, theseusandtheminotaur = 33, vertex = 34, stickercollectorrobot = 35, mappingtheroute = 36
			, journeytothemoon = 37, knightinthewargrid = 38, forwardingemails = 39, coinchangedp = 40
			, dfscyclic = 41, ledtest = 42, banknotquiteocr = 43, ancientmessages = 44, llgiocodellx = 45
			, hmactokopedia = 46, binarysearchtree = 47, continents = 48, battleship = 49, orderingtask = 50
			, ordering = 51, followingorder = 52, reconnecting = 53, prim_mst_special_subtree = 54, network = 55
			, critical_link = 56, racing = 57, highways = 58, acm_and_blackout = 59, audiophobia=60;

    public static final void run(int category, int prob_num){
		switch (category) {
		case unknown:
			switch (prob_num) {
			case hmactokopedia:
				new HMacTokopedia();
				break;
			case binarysearchtree:
				new BSTExample();
				break;
			default:
				break;
			}
			break;
		case dynamic_programming:
			switch(prob_num){
			case coinchangedp:
				new CoinChangeDP();
				break;
			}
			break;
		case greedy:
			switch(prob_num){
			case reconnecting:
				new Reconnecting();
				break;
			case prim_mst_special_subtree:
				new PrimMSTSpecialSubTree();
				break;
			}
			break;
		case backtrack:

			break;
		case recursive_backtrack:
			switch (prob_num) {
			case ledtest:
				new LEDTest();
				break;
			}
			break;
		case graph:
			switch(prob_num){
				case audiophobia:
					new AudioPhobia();
					break;
				case acm_and_blackout:
					new ACMAndBlackout();
					break;
				case highways:
					new Highways2();
					break;
			case racing:
				new Racing2();
				break;
			case dfscyclic:
				new DFSCyclicLearn();
				break;
			case shortestreach:
				new ShortestReach();
				break;
			case rushmurderer:
				new RustMurderer();
				break;
			case theseusandtheminotaur:
				new TheseusAndTheMinotaur();
				break;
			case vertex:
				new Vertex();
				break;
			case stickercollectorrobot:
				new StickerCollectorRobot();
				break;
			case mappingtheroute:
				new MappingTheRoute();
				break;
			case journeytothemoon:
				new JourneyToTheMoon();
				break;
			case knightinthewargrid:
				new KnightInWarGrid();
				break;
			case forwardingemails:
				new ForwardingEmails();
				break;
			case ancientmessages:
				new AncientMessages();
				break;
			case llgiocodellx:
				new llGiocoDellX();
				break;
			case continents:
				new Continents();
				break;
			case battleship:
				new Battleships();
				break;
			case orderingtask:
				new OrderingTask();
				break;
			case ordering:
				new Ordering();
				break;
			case reconnecting:
				new Reconnecting();
				break;
			case network:
				new Network();
				break;
			case critical_link:
				new CriticalLinks();
				break;
			}
			break;
		case sorting:
			switch (prob_num) {
			case introsorting:
				new IntroSorting(template.LINUX);
				break;
			case quicksortinplace:
				new QuickSortInPlace();
				break;
			default:
				break;
			}
			break;
		case uva:
			switch (prob_num) {
			case backtoeightqueens:
				new BackToTheEightQueens();
				break;
			case callforwarding:
				new CallForwarding();
				break;
			case cd:
				new CD();
				break;
			case chestOfDrawers:
				new ChestOfDrawers();
				break;
			case division:
				new Division();
				break;
			case dominator:
				new Dominator();
				break;
			case dragonofloowater:
				new DragonOfLoowater();
				break;
			case eightqueenproblem:
				new EightQueenChessProblem();
				break;
			case expertEnough:
				new ExpertEnough();
				break;
			case granddiner:
				new GrandDinner();
				break;
			case grapevine:
				new Grapevine();
				break;
			case hammingdistance:
				new HammingDistance();
				break;
			case hanoitowerproblemagain:
				new HanoiTowerProblemAgain();
				break;
			case wetlandofflorida:
				new WetlandsOfFlorida();
				break;
			case theseusandtheminotaur:
				new TheseusAndTheMinotaur();
				break;
			case vertex:
				new Vertex();
				break;
			case stickercollectorrobot:
				new StickerCollectorRobot();
				break;
			case mappingtheroute:
				new MappingTheRoute();
				break;
			case knightinthewargrid:
				new KnightInWarGrid();
				break;
			case forwardingemails:
				new ForwardingEmails();
				break;
			case ledtest:
				new LEDTest();// LEDTestV2() failed solution 
				break;
			case banknotquiteocr:
				new BankNotQuiteOCR();
				break;
			case ancientmessages:
				new AncientMessages();
				break;
			case llgiocodellx:
				new llGiocoDellX();
				break;
			case continents:
				new Continents();
				break;
			case battleship:
				new Battleships();
				break;
			case ordering:
				new Ordering();
				break;
			case followingorder:
				new FollowingOrder();
				break;
			default:
				break;
			}
			break;
		case srin_sotong:
				switch (prob_num) {
				case bomberman:
					new Bomberman();
					break;
				case bughunter:
					new BugHunters();
					break;
				case cellRemoval:
					new CellRemoval();
					break;
				case evenfibo:
					new Evenfibo();
					break;
				case highestpeak:
					new HighestPeak();
					break;
				case bicoloring:
					new BiColoring();
					break;
				case orderingtask:
					new OrderingTask();
					break;
				default:
					break;
				}
			break;
		case hackkerank:
			switch (prob_num) {
			case countLuck:
				new CountLuck();
				break;
			case eventree:
				new EvenTree();
				break;
			case gridchallenge:
				new GridChallenge();
				break;
			case introsorting:
				new IntroSorting(template.LINUX);
				break;
			case quicksortinplace:
				new QuickSortInPlace();
				break;
			case averybigsum:
				new AVeryBigSum();
				break;
			case diagonaldifference:
				new DiagonalDifference();
				break;
			case reformatthedate:
				new ReformatTheDate();
				break;
			case visitedcell:
				new VisitedCell();
				break;
			case pascaltriangle:
				new PascalTriangle();
				break;
			case shortestreach:
				new ShortestReach();
				break;
			case rushmurderer:
				new RustMurderer();
				break;
			case journeytothemoon:
				new JourneyToTheMoon();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

}
