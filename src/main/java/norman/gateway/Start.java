package norman.gateway;

import norman.template.template_factory;

/**
 * This is the execution for all algorithm implementation
 * @author m.normansyah
 * started at 25-6-2015
 */
public class Start {
	public static void main(String[] args) {
		// hackerrank

		// recursive
		template_factory.run(template_factory.dynamic_programming, template_factory.davis_staircase);

		// shortest reach 2 - testcase 7 failed - input output reading
//		template_factory.run(template_factory.graph, template_factory.shortestreach2);

		// Prim's (MST) : Special Subtree
//		template_factory.run(template_factory.greedy, template_factory.prim_mst_special_subtree);
		
		// count luck
//		template_factory.run(template_factory.hackkerank, template_factory.countLuck);

		// even tree
//		template_factory.run(template_factory.hackkerank, template_factory.eventree);

		// grid challenge
//		template_factory.run(template_factory.hackkerank, template_factory.gridchallenge);
		
		// very easy - not sorting
//		template_factory.run(template_factory.hackkerank, template_factory.introsorting);
		
		// TODO don't know below problem status
		// easy quick sort simulation 
//		template_factory.run(template_factory.hackkerank, template_factory.quicksortinplace);
		
		// easy problem, just addition
//		template_factory.run(template_factory.hackkerank, template_factory.averybigsum);
		
		// easy problem, just addition in matrix
//		template_factory.run(template_factory.hackkerank, template_factory.diagonaldifference);
		
		// tokopedia entrance test
//		template_factory.run(template_factory.hackkerank, template_factory.reformatthedate);
		
		// tokopedia entrance test #2
//		template_factory.run(template_factory.hackkerank, template_factory.visitedcell);
		
		// tokopedia entrance test #3
//		template_factory.run(template_factory.hackkerank, template_factory.pascaltriangle);
		
		// breadth first search : shortest reach
//		template_factory.run(template_factory.hackkerank, template_factory.shortestreach);
		
		// rush murderer ( already 100% )
//		template_factory.run(template_factory.hackkerank, template_factory.rushmurderer);
		
		// following order - uva 124
//		template_factory.run(template_factory.uva, template_factory.followingorder);
		
		// UVa 00908 - Re-connecting
//		template_factory.run(template_factory.graph, template_factory.reconnecting);
		
		// journey to the moon, connected component
//		template_factory.run(template_factory.hackkerank, template_factory.journeytothemoon);

		// uva problem

		// word transformation - uva 429
//		template_factory.run(template_factory.graph, template_factory.word_transformation);

		// standard mst problem - but the weightest from its choice
//		template_factory.run(template_factory.graph, template_factory.heavy_cycle_edges);

		// standard mst problem - but difficult to understand
//		template_factory.run(template_factory.graph, template_factory.dark_roads);

		// transportation system 11228 - tricky problem
//		template_factory.run(template_factory.graph, template_factory.transportation_system);

		// acm and blackout - minimax - minimum spanning tree
//		template_factory.run(template_factory.graph, template_factory.audiophobia);

		// acm and blackout - second minimum spanning tree
//		template_factory.run(template_factory.graph, template_factory.acm_and_blackout);

		// highway 10147 - minimum spanning subgraph
//		template_factory.run(template_factory.graph, template_factory.highways);

		// racing uva 1234
//		template_factory.run(template_factory.graph, template_factory.racing);

		// critical link - find bridge 
//		template_factory.run(template_factory.graph, template_factory.critical_link);
		// network - find articulation 
//		template_factory.run(template_factory.graph, template_factory.network);
		
		// hamming distance
//		template_factory.run(template_factory.uva, template_factory.hammingdistance);

		// hanoi tower problem again
//		template_factory.run(template_factory.uva, template_factory.hanoitowerproblemagain);

		// grand dinner
//		template_factory.run(template_factory.uva, template_factory.grapevine);

		// grand dinner
//		template_factory.run(template_factory.uva, template_factory.granddiner);

		// expert enough
//		template_factory.run(template_factory.uva, template_factory.expertEnough);

		// eight queen of problem
//		template_factory.run(template_factory.uva, template_factory.eightqueenproblem);

		// dominator
//		template_factory.run(template_factory.uva, template_factory.dominator);

		// division by me only
//		template_factory.run(template_factory.uva, template_factory.division);

		// back to eight queens, input is empty
		// TODO please add input for backtoeight
//		template_factory.run(template_factory.uva, template_factory.backtoeightqueens);

		// call forwarding
//		template_factory.run(template_factory.uva, template_factory.callforwarding);

		// CD
		// TODO input is problem here
//		template_factory.run(template_factory.uva, template_factory.cd);

		// Chest Of Drawers
		// TODO still couldn't solve it even cheat using google
//		template_factory.run(template_factory.uva, template_factory.chestOfDrawers);
		
		// graph floodfill
//		template_factory.run(template_factory.uva, template_factory.wetlandofflorida);
		
		// graph dfs theseus and the minotaur
//		template_factory.run(template_factory.uva, template_factory.theseusandtheminotaur);
		
		// graph dfs easy
//		template_factory.run(template_factory.uva, template_factory.vertex);
		
		// sticker collector robot
//		template_factory.run(template_factory.uva, template_factory.stickercollectorrobot);
		
		// mapping the route, graph transversal
//		template_factory.run(template_factory.uva, template_factory.mappingtheroute);
		
		// Knight in War Grid, dfs tricky, failed ( runtime error )
//		template_factory.run(template_factory.uva, template_factory.knightinthewargrid);
		
		// forwarding emails
//		template_factory.run(template_factory.uva, template_factory.forwardingemails);
		
		// recursive backtracking / try all
//		template_factory.run(template_factory.uva, template_factory.ledtest);
		
		// recursive backtracking / try all, failed in java : Map don't know which order 
//		template_factory.run(template_factory.uva, template_factory.banknotquiteocr);
		
		// graph - connected component , failed at some test cases and stackoverflow
//		template_factory.run(template_factory.uva, template_factory.ancientmessages);
		
		// graph - connected component , 6 ways to move
//		template_factory.run(template_factory.uva, template_factory.llgiocodellx);
		
		// example of coin change dp
//		template_factory.run(template_factory.dynamic_programming, template_factory.coinchangedp);
		
		// example of checking cyclic using dfs 
//		template_factory.run(template_factory.graph, template_factory.dfscyclic);
		
		// connected component - graph uva 11094
//		template_factory.run(template_factory.graph, template_factory.continents);
		
		// connected component - graph uva 11953 - BattleShips
//		template_factory.run(template_factory.graph, template_factory.battleship);
		
		// topologycal sort - modified dfs uva 10305
//		template_factory.run(template_factory.graph, template_factory.orderingtask);
		
		// alike topological sort uva 872
//		template_factory.run(template_factory.graph, template_factory.ordering);

		// SRIN Sotong exerices 2015

		// Bomberman Problem
//		 template_factory.run(template_factory.srin_sotong, template_factory.bomberman);

		// bughunter isn't solve yet
//		 template_factory.run(template_factory.srin_sotong,template_factory.bughunter);

		// cell removal
//		template_factory.run(template_factory.srin_sotong, template_factory.cellRemoval);

		// even fibo
//		template_factory.run(template_factory.srin_sotong, template_factory.evenfibo);

		// highest peak
//		template_factory.run(template_factory.srin_sotong, template_factory.highestpeak);
		
		// bicoloring ( uva dfs or bfs )
//		template_factory.run(template_factory.srin_sotong, template_factory.bicoloring);
		
		// tokopedia hmac 
//		template_factory.run(template_factory.unknown, template_factory.hmactokopedia);
		
		// binary search tree example
		// template_factory.run(template_factory.unknown, template_factory.binarysearchtree);

		// general knowledge
//		template_factory.run(template_factory.graph, template_factory.kahn_topological_sort);

		// uva 11060 - beverages
//		template_factory.run(template_factory.graph, template_factory.beverages);
	}
}
