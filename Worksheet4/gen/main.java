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

public class main extends ASTRAClass {
	public main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args")
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"main", new int[] {3,27,7,5},
				new Statement[] {
					new ModuleCall("S",
						"main", new int[] {4,8,4,46},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("launcher"),
							Primitive.newPrimitive("booklaunch")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("main","S")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("S",
						"main", new int[] {5,8,5,44},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("customer"),
							Primitive.newPrimitive("customer")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("main","S")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("S",astra.lang.System.class,agent);
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
			astra.core.Agent agent = new main().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
