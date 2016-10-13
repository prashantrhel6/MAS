/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.acre.*;
import astra.cartago.*;
import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.eis.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;

public class booklaunch extends ASTRAClass {
	public booklaunch() {
		setParents(new Class[] {book_service.class});
		addRule(new Rule(
			new BeliefEvent('+',
				new Predicate("clock", new Term[] {
					new Variable(Type.INTEGER, "X")
				})
			),
			Predicate.TRUE,
			new Block(
				"booklaunch", new int[] {10,23,17,5},
				new Statement[] {
					new ModuleCall("S",
						"booklaunch", new int[] {11,8,11,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("booklaunch","S")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('-',
						"booklaunch", new int[] {12,8,17,5},
						new Predicate("clock", new Term[] {
							new Variable(Type.INTEGER, "X")
						})
					),
					new BeliefUpdate('+',
						"booklaunch", new int[] {14,8,17,5},
						new Predicate("clock", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "X"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new SpawnGoal(
						"booklaunch", new int[] {16,8,17,5},
						new Goal(
							new Predicate("tick", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("tick", new Term[] {})
				)
			),
			new Predicate("clock", new Term[] {
				new Variable(Type.INTEGER, "X")
			}),
			new Block(
				"booklaunch", new int[] {19,31,21,5},
				new Statement[] {
					new ModuleCall("C",
						"booklaunch", new int[] {20,8,20,47},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Ticking the Clock !!! "),
								new Variable(Type.INTEGER, "X")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("booklaunch","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("clock", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("S",astra.lang.System.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new BasicSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new booklaunch().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
