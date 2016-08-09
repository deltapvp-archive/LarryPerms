/*
 * Copyright (c) 2016 Lucko (Luck) <luck@lucko.me>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.api.implementation.internal;

import lombok.experimental.UtilityClass;
import me.lucko.luckperms.api.Group;
import me.lucko.luckperms.api.Track;
import me.lucko.luckperms.api.User;
import me.lucko.luckperms.utils.ArgumentChecker;

@UtilityClass
class Utils {

    static void checkUser(User user) {
        if (!(user instanceof UserLink)) {
            throw new IllegalArgumentException("User instance cannot be handled by this implementation.");
        }
    }

    static void checkGroup(Group group) {
        if (!(group instanceof GroupLink)) {
            throw new IllegalArgumentException("Group instance cannot be handled by this implementation.");
        }
    }

    static void checkTrack(Track track) {
        if (!(track instanceof TrackLink)) {
            throw new IllegalArgumentException("Track instance cannot be handled by this implementation.");
        }
    }

    static String checkUsername(String s) {
        if (!ArgumentChecker.checkUsername(s)) {
            throw new IllegalArgumentException("Invalid username entry '" + s + "'. Usernames must be less than 16 chars" +
                    " and only contain 'a-z A-Z 1-9 _'.");
        }
        return s;
    }

    static String checkName(String s) {
        if (!ArgumentChecker.checkName(s)) {
            throw new IllegalArgumentException("Invalid name entry '" + s + "'. Names must be less than 37 chars" +
                    " and only contain 'a-z A-Z 1-9'.");
        }
        return s.toLowerCase();
    }

    static String checkServer(String s) {
        if (!ArgumentChecker.checkServer(s)) {
            throw new IllegalArgumentException("Invalid server entry '" + s + "'. Server names can only contain alphanumeric characters.");
        }
        return s;
    }

    static String checkNode(String s) {
        if (!ArgumentChecker.checkNode(s)) {
            throw new IllegalArgumentException("Invalid node entry '" + s + "'. Nodes cannot contain '/' or '$' characters.");
        }
        return s;
    }

    static long checkTime(long l) {
        if (!ArgumentChecker.checkTime(l)) {
            throw new IllegalArgumentException("Unix time '" + l + "' is invalid, as it has already passed.");
        }
        return l;
    }

}
