/**
 * This package contains classes responsible for converting between DTO
 * (Data Transfer Object) objects and entity objects in the business
 * layer of the application.
 *
 * <p>The conversion classes in this package provide methods to convert DTO
 * objects to entity objects and vice versa, facilitating data transfer between
 * different layers of the application.</p>
 *
 * <p>Conversion classes in this package:</p>
 * <ul>
 *     <li>{@link co.simplon.gamebotsback.business.convert.ConversationConvert}
 *     - Converts ConversationDTO to Conversation entity</li>
 *     <li>{@link co.simplon.gamebotsback.business.convert.GameConvert}
 *     - Converts GameDTO to Game entity</li>
 *     <li>{@link co.simplon.gamebotsback.business.convert.ImageConvert}
 *     - Converts ImageDTO to Image entity</li>
 *     <li>{@link co.simplon.gamebotsback.business.convert.MessageConvert}
 *     - Converts MessageDTO to Message entity</li>
 *     <li>{@link co.simplon.gamebotsback.business.convert.TypeImageConvert}
 *     - Converts TypeImageDTO to TypeImage entity</li>
 *     <li>{@link co.simplon.gamebotsback.business.convert.UserConvert}
 *     - Converts UserDTO to User entity</li>
 * </ul>
 *
 * <p>These conversion classes help maintain separation of concerns and keep
 * the codebase organized by encapsulating the logic for converting data
 * between different object types.</p>
 *
 * @version 1.0
 * @author Yoan Bor
 * @author Florian Poteau
 * @since 2024-05-08
 */

package co.simplon.gamebotsback.business.convert;
