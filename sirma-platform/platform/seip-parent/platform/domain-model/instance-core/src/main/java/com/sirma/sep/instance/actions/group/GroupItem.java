package com.sirma.sep.instance.actions.group;

import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import com.sirma.itt.seip.definition.TransitionGroupDefinition;

/**
 * Action menu member, that wraps {@link TransitionGroupDefinition} object.
 *
 * @author T. Dossev
 */
public class GroupItem implements ActionMenuMember {

	private TransitionGroupDefinition group;

	/**
	 * Constructs a {@link TransitionGroupDefinition} wrapper.
	 *
	 * @param group
	 *            current group
	 */
	public GroupItem(TransitionGroupDefinition group) {
		this.group = group;
	}

	@Override
	public Object toJsonHelper() {
		JsonObjectBuilder createObjectBuilder = Json.createObjectBuilder();
		Map<String, String> itemProperties = TransitionGroupDefinition.getProperties(group);

		for (Entry<String, String> entry : itemProperties.entrySet()) {
			createObjectBuilder.add(entry.getKey(), entry.getValue());
		}
		return createObjectBuilder;
	}

	@Override
	public String getIdentifier() {
		return group.getIdentifier();
	}

	@Override
	public Integer getOrder() {
		return group.getOrder();
	}

	@Override
	public String getParent() {
		return group.getParent();
	}

}
