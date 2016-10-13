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

public class Main2 extends ASTRAClass {
	public Main2() {
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
				"Main2", new int[] {4,27,9,5},
				new Statement[] {
					new ModuleCall("M",
						"Main2", new int[] {5,8,5,64},
						new Predicate("installService", new Term[] {
							Primitive.newPrimitive("rmi"),
							Primitive.newPrimitive("astra.messaging.rmi.RMIService")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Messaging) intention.getModule("Main2","M")).installService(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("M",
						"Main2", new int[] {6,8,6,29},
						new Predicate("startService", new Term[] {
							Primitive.newPrimitive("rmi")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Messaging) intention.getModule("Main2","M")).startService(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"Main2", new int[] {8,8,8,44},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("customer"),
							Primitive.newPrimitive("customer")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main2","S")).createAgent(
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
		fragment.addModule("M",astra.lang.Messaging.class,agent);
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
			astra.core.Agent agent = new Main2().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
