/*
 *    Copyright 2021 Lero4ka16
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.lero4ka16.ef4j;

/**
 * @author lero4ka16
 */
public interface EventBus extends EventNamespace {

	static EventBus create() {
		return create(true);
	}

	static EventBus create(boolean isSynchronized) {
		return isSynchronized
				? new EventBusSyncImpl()
				: new EventBusImpl();
	}

	EventObjectSubscription subscribe(Object listener);

	EventObjectSubscription subscribe(EventNamespace namespace, Object listener);

	void unsubscribe(EventSubscription<?> subscription);

	void unsubscribe(EventObjectSubscription subscription);

	void unsubscribeAll(EventNamespace namespace);

	void unsubscribeAll();

	void publish(Event event);

}
