package norman.template;

import norman.hackerrank.*;
import norman.srin.algorithm.*;
import norman.unknown.*;
import norman.uva.*;

public abstract class TemplateFactory {
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
			, hmactokopedia = 46, binarysearchtree = 47, continents = 48, battleship = 49, orderingtask = 50, ordering = 51
			, followingorder = 52, reconnecting = 53, prim_mst_special_subtree = 54, network = 55, critical_link = 56
			, racing = 57, highways = 58, acm_and_blackout = 59, audiophobia = 60, transportation_system = 61, dark_roads = 62
			, heavy_cycle_edges = 63, kahn_topological_sort = 64, beverages = 65, shortestreach2 = 66, word_transformation = 67
			, davis_staircase = 68, balanced_brackets = 69, sherlock_and_the_cost = 70, candies = 71, greedy_florist = 72
			, number_maze = 73, boardcutting = 74, knapsack = 75, diving_for_gold = 76, wormhole = 77, barcodes = 78
			, max_sub_array = 79, word_justification = 80, flight_planner = 81, test_template = 82, sam_and_sub_strings = 83
			, blackjack = 84, brick_games = 85, how_to_add = 86, lowest_price_in_town = 87, y2k = 88, hanoitower = 89
			, history_grading = 90, what_goes_up = 91, summing_pieces = 92, kingdom_division = 93
			, william_pet=94, abbrevia_wil = 95, sum_of_different_pieces=96, fair_cut = 97, lets_yum_cha = 98, coin_sum_tree = 99
			, kingdom_division_my_own = 100, diameter_of_tree = 101, steve_explorer =102, mobile=103;

	public static void run(int category, int prob_num) {
		switch (category) {
		case unknown:
			switch (prob_num) {
				case abbrevia_wil:
					new AbbrevationWil();
					break;
				case william_pet:
					new WilliamPet();
					break;
				case blackjack:
					new BlackJack();
					break;
				case test_template:
					new Template2Test();
					break;
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
				case mobile:
					new Mobile();
					break;
				case steve_explorer:
					// failed to understand, maybe asking more experienced than me.
					new SteveExplorer();
					break;
				case diameter_of_tree:
					new DiameterOfTree();
//					new DiameterOfTree2();
					break;
				case kingdom_division_my_own :
					new KingdomDivisionMyOwn();
					break;
				case coin_sum_tree:
					new CoinSumTree();
					break;
				case lets_yum_cha:
					new LetsYumCha();
					break;
				case fair_cut:
					new FairCut();
					break;
				case kingdom_division:
					new KingdomDivision();
					break;
				case summing_pieces:
					new SummingPieces();
					break;
				case what_goes_up:
					new WhatGoesUp();
					break;
				case history_grading:
					new HistoryGrading();
					break;
				case lowest_price_in_town:
					new LowestPriceInTheTown();
					break;
				case how_to_add:
					new HowToAdd();
					break;
				case brick_games:
					new BrickGame();
					break;
				case flight_planner:
					new FlightPlanner();
					break;
				case word_justification:
					new WordJustification();
					break;
				case max_sub_array:
					new MaximalSubArray();
					break;
				case barcodes:
					new BarCodes();
					break;
				case wormhole:
					new Wormholes();
					break;
				case diving_for_gold:
					new DivingForGold();
					break;
				case knapsack:
					new Knapsack();
					break;
				case davis_staircase:
					new DarvisStaircase();
					break;
				case coinchangedp:
					new CoinChangeDP();
					break;
			}
			break;
		case greedy:
			switch(prob_num){
				case boardcutting:
					new BoardCutting();
					break;
			case reconnecting:
				new Reconnecting();
				break;
			case prim_mst_special_subtree:
				new PrimMSTSpecialSubTree();
				break;
			}
			break;
		case backtrack:
			switch (prob_num) {
				case y2k:
					new Y2K();
					break;
				case hanoitower:
					new HanoiTower();
					break;
			}
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
				case number_maze:
					new NumberMaze();
					break;
				case word_transformation:
					new WordTransformation();
					break;
				case shortestreach2:
					new ShortestReach2();
					break;
				case beverages:
					new Beverages();
					break;
				case kahn_topological_sort:
					new KahnTopSort();
					break;
				case heavy_cycle_edges:
					new HeavyCycleEdges();
					break;
				case dark_roads:
					new DarkRoads();
					break;
				case transportation_system:
					new TransportationSystem();
					break;
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
				new IntroSorting(Template.LINUX);
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
				case sum_of_different_pieces:
					new SumOfDifferentPrimes();
					break;
			case backtoeightqueens:
				new BackToTheEightQueens();
				break;
			case callforwarding:
				new CallForwarding();
				break;
			case cd:
				new CD2();
				//[START] This is old code
//				new CD();
				//[END] This is old code
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
				case sam_and_sub_strings:
					new SamAndSubStrings();
					break;
				case greedy_florist:
					new GreedyFlorist();
					break;
				case candies:
					new Candies();
					break;
				case sherlock_and_the_cost:
					new SherlockAndTheCost2();
//					new SherlockAndTheCost();// naive solution
					break;
				case balanced_brackets:
					new BalancedBrackets();
					break;
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
				new IntroSorting(Template.LINUX);
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
